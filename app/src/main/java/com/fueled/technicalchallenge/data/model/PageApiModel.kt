package com.fueled.technicalchallenge.data.model

import com.squareup.moshi.JsonClass

/**
 * Created by bhavya@fueled.com on 17/10/2024.
 */
@JsonClass(generateAdapter = true)
data class PageApiModel<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>,
)