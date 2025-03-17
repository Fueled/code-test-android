package com.fueled.technicalchallenge.data

import com.fueled.technicalchallenge.data.model.ResponseApiModel
import okhttp3.ResponseBody
import retrofit2.Converter

/**
 * Created by bhavya@fueled.com on 18/10/2024.
 */
class UnWrapper<T>(private val converter: Converter<ResponseBody, ResponseApiModel<T>>?) :
    Converter<ResponseBody, T> {
    override fun convert(value: ResponseBody): T? = converter?.convert(value)?.data
}