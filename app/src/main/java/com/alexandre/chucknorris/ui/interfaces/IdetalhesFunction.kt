package com.alexandre.chucknorris.ui.interfaces

import com.alexandre.chucknorris.data.response.ChuckResultResponse

interface IdetalhesFunction {

    fun getDetalhes(lista : List<ChuckResultResponse>)
}