package com.example.pinboardassignment.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.network.APICallService
import javax.inject.Inject
import javax.inject.Singleton



/**
 * @author: SundravelS
 *
 * @desc: Below is data source  class used to retrieve data from server
 */

@Singleton
class RemoteDataSource @Inject constructor(val apiCallService: APICallService) {
    suspend fun <T> callAPI(
        sUrl: String,
        tClass: Class<T>,
        bPostOrGET: Boolean = false,
        bJsonArray: Boolean = false
    ): HandleResponse<T> {
        return try {
            val response = when (bPostOrGET) {
                true -> apiCallService.postRequest(sUrl)
                else -> apiCallService.getResponse(sUrl)
            }
            HandleResponse.parseResponse(response, tClass = tClass, bJsonArray = bJsonArray)
        } catch (e: Exception) {

            HandleResponse.parseResponse(null, tClass = tClass)

        }

    }

    //download files
    suspend fun downloadFile(
        sUrl: String,
        bPostOrGET: Boolean = false,
    ): Bitmap? {
        return try {
            val response = when (bPostOrGET) {
                true -> apiCallService.postRequest(sUrl)
                else -> apiCallService.getResponse(sUrl)
            }

            val inputStream = response.body()?.byteStream()
            return BitmapFactory.decodeStream(inputStream)


        } catch (e: Exception) {
            null
        }

    }


}