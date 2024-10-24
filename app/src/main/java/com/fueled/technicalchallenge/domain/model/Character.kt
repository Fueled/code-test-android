package com.fueled.technicalchallenge.domain.model

import com.squareup.moshi.JsonClass

/**
 * Created by bhavya@fueled.com on 17/10/2024.
 */
@JsonClass(generateAdapter = true)
data class Character(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: Image,
    val resourceURI: String,
    val events: ResourceItems,
    val urls: List<Url>,
)