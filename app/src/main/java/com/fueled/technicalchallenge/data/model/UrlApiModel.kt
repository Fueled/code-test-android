package com.fueled.technicalchallenge.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrlApiModel(val type: String, val url: String)
