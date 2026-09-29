package com.example.androidcomponentsdemo

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast

class BackgroundDemoService : Service() {
    override fun onCreate() {
        super.onCreate()

        Toast.makeText(
            this,
            "Background Service Created",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(
            this,
            "Background Service started",
            Toast.LENGTH_SHORT
        ).show()

        Thread{
            Thread.sleep(5000)
            Handler(Looper.getMainLooper()).post {       //Run this particular piece of code on Android's main thread."
                Toast.makeText(
                    this,
                    "Background work completed",
                    Toast.LENGTH_SHORT
                ).show()
            }
            stopSelf()                  //A Service doesn't automatically stop just because its work is finished.
        }.start()
        return START_NOT_STICKY
    }

    override fun onDestroy() {

        Toast.makeText(
            this,
            "Background Service Destroyed",
            Toast.LENGTH_SHORT
        ).show()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}