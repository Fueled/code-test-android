package com.fueled.technicalchallenge.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResourceApiModel(val resourceURI: String, val name: String, val type: String?)
