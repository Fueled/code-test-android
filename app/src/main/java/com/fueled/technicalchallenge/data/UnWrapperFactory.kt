package com.fueled.technicalchallenge.data

import com.fueled.technicalchallenge.data.model.ResponseApiModel
import com.squareup.moshi.Types
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * Created by bhavya@fueled.com on 18/10/2024.
 */
object UnWrapperFactory : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit,
    ): Converter<ResponseBody, *> {
        val envelopedType = Types.newParameterizedType(ResponseApiModel::class.java, type)
        val delegate: Converter<ResponseBody, ResponseApiModel<Any>>? =
            retrofit.nextResponseBodyConverter(this, envelopedType, annotations)
        return UnWrapper(delegate)
    }
}