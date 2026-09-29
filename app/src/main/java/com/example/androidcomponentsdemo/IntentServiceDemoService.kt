package com.example.androidcomponentsdemo

import android.app.IntentService
import android.content.Intent
import android.util.Log

class IntentServiceDemoService : IntentService("IntentDemoService"){
    override fun onHandleIntent(intent: Intent?) {
        Log.d("IntentDemo", "IntentService started")
        Thread.sleep(5000)
        Log.d("IntentDemo" , "Background work completed")
    }
}