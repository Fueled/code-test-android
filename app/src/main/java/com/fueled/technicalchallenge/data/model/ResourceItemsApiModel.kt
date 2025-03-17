package com.fueled.technicalchallenge.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResourceItemsApiModel(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<ResourceApiModel>,
)
