package com.example.androidcomponentsdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import androidx.compose.runtime.Composable

class DemoService : Service(){
    override fun onCreate() {
        super.onCreate()

        Toast.makeText(this,
            "Service created",
            Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(
            this,
            "Service started",
            Toast.LENGTH_SHORT
        ).show()

        return START_STICKY
    }

    override fun onDestroy() {
        Toast.makeText(
            this,
            "Service Destroyed",
            Toast.LENGTH_SHORT
        ).show()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

}
