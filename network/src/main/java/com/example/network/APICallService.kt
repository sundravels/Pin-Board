package com.example.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url


/**
 * @author: SundravelS
 *
 * @desc: Below interface is used for calling API.
 */

interface APICallService {
    @GET
    suspend fun getResponse(@Url sUrl: String): Response<ResponseBody>

    @POST
    suspend fun postRequest(@Url sUrl: String): Response<ResponseBody>

}