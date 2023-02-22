package com.example.pinboardassignment.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.network.APICallService
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author: SundravelS
 *
 * @desc: Below class is a repository class used to manage data source
 */
@Singleton
class GenericRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun <T> callAPI(
        sUrl: String,
        tClass: Class<T>,
        bPostOrGET: Boolean = false,
        bJsonArray: Boolean = false
    ): HandleResponse<T> {
        return  remoteDataSource.callAPI(sUrl,tClass,bPostOrGET,bJsonArray)
    }

    //download files
    suspend fun downloadFile(
        sUrl: String,
        bPostOrGET: Boolean = false,
    ): Bitmap? {
        return remoteDataSource.downloadFile(sUrl,bPostOrGET)
    }


}