package com.example.pinboardassignment.utils

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author: SundravelS
 *
 * @desc: Below is generic class used for printing Logs throughout the app.
 */


@Singleton
class LoggerClass @Inject constructor() {

    fun <T> verbose(sTAG: String = "TAG", data: T) {
        Log.v(sTAG, "${data}")
    }

    companion object {
        fun getLoggerClass() = LoggerClass()

    }

}