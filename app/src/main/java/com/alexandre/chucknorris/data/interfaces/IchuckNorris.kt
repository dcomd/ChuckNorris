package com.alexandre.chucknorris.data.interfaces

import com.alexandre.chucknorris.data.response.ChuckJokesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IchuckNorris {

    @GET("/jokes/categories")
    suspend fun getategories(): retrofit2.Response<Array<String>>

    @GET("/jokes/search")
    suspend fun searchByCategorie(
        @Query("query") query: String
    ): retrofit2.Response<ChuckJokesResponse>
}