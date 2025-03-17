package com.fueled.technicalchallenge.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageApiModel(val path: String, val extension: String)
