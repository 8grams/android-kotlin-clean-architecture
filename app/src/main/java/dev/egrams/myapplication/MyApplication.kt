package dev.egrams.myapplication

import android.app.Application

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        lateinit var appInstance: MyApplication
        fun getInstance(): MyApplication {
            return appInstance
        }
    }
}