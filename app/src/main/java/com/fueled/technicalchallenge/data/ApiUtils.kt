package com.fueled.technicalchallenge.data

import com.fueled.technicalchallenge.data.ApiConstants.PRIVATE_KEY
import com.fueled.technicalchallenge.data.ApiConstants.PUBLIC_KEY
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

/**
 * Created by bhavya@fueled.com on 18/10/2024.
 */
object ApiUtils {

    val currentTimestamp: String = System.currentTimeMillis().toString()

    val hash: String by lazy {
        val input = currentTimestamp + PRIVATE_KEY + PUBLIC_KEY
        md5(input)
    }

    private fun md5(input: String): String {
        val bytes = MessageDigest.getInstance("MD5").digest(input.toByteArray(StandardCharsets.UTF_8))
        return bytes.joinToString("") { "%02x".format(it) }
    }
}