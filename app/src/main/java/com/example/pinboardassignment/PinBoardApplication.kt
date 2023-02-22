package com.example.pinboardassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PinBoardApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}