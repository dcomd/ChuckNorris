package com.alexandre.chucknorris.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChuckJokesResponse (
    @Json(name = "result")
    val result : List<ChuckResultResponse>
)