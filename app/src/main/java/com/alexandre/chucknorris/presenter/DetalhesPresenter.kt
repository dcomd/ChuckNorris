package com.alexandre.chucknorris.presenter

import com.alexandre.chucknorris.data.repository.ChuckNorrisRepository
import com.alexandre.chucknorris.data.response.ChuckResultResponse
import com.alexandre.chucknorris.ui.interfaces.IdetalhesFunction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class DetalhesPresenter(
    val view: IdetalhesFunction,
    val repository: ChuckNorrisRepository
) {

    fun getCategories(query: String) {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val retorno = repository.executeSearch(query)
                if (retorno.isSuccessful) {
                    val lista : MutableList<ChuckResultResponse> = mutableListOf()
                    retorno.body()?.let {
                        for(item in it.result){
                            val chuckJokes = ChuckResultResponse(
                                icon_url = item.icon_url,
                                url = item.url,
                                value = item.value
                            )

                            lista.add(chuckJokes)
                        }

                        view.getDetalhes(lista)
                    }
                }
            } catch (exception: HttpException) {

            }
        }

    }

}