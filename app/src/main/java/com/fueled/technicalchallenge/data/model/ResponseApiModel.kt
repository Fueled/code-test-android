package com.fueled.technicalchallenge.data.model

import com.squareup.moshi.JsonClass

/**
 * Created by bhavya@fueled.com on 18/10/2024.
 */
@JsonClass(generateAdapter = true)
data class ResponseApiModel<T>(val code: Int, val status: String, val etag: String, val data: T)