package com.alexandre.chucknorris.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoriesResponse (val categories : String)


