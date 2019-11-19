package com.alexandre.chucknorris.data.repository

import com.alexandre.chucknorris.data.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisRepository {

    suspend fun executeGet() = withContext(Dispatchers.IO) {
        val api = RetrofitInstance.getRetrofit()
        return@withContext api.getategories()
    }

    suspend fun executeSearch(query: String) = withContext(Dispatchers.IO) {
        val api = RetrofitInstance.getRetrofit()
        return@withContext api.searchByCategorie(query)
    }
}