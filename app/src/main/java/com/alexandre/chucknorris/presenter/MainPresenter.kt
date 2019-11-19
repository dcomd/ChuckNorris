package com.alexandre.chucknorris.presenter


import com.alexandre.chucknorris.data.repository.ChuckNorrisRepository
import com.alexandre.chucknorris.data.response.CategoriesResponse
import com.alexandre.chucknorris.ui.interfaces.ImainFunction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException


class MainPresenter(
    val view: ImainFunction,
    val repository: ChuckNorrisRepository
) {


    fun getCategories() {
        var list: MutableList<CategoriesResponse> = mutableListOf()

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val retorno = repository.executeGet()


                if (retorno.isSuccessful) {

                    retorno.body()?.let {

                        for(item in it){

                            val categoriesResponse = CategoriesResponse(
                                categories = item
                            )

                            list.add(categoriesResponse)
                        }
                        view.getCategorias(list)
                    }


                }
            } catch (exception: HttpException) {

            }
        }

    }


}