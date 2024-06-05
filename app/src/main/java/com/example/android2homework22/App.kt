package com.example.android2homework22

import android.app.Application
import android.content.Context
import com.example.android2homework22.utils.PreferenceHelper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
    }
}