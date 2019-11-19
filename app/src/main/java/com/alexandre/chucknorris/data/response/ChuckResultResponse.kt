package com.alexandre.chucknorris.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChuckResultResponse(
    @Json(name = "icon_url")
    val icon_url: String = "",
    @Json(name = "url")
    val url: String = "",
    @Json(name = "value")
    val value: String = ""

)