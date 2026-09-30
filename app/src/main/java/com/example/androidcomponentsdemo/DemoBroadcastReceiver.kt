package com.example.androidcomponentsdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class DemoBroadcastReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?,           //tells us about the environment/app from which the receiver is running.
                           intent: Intent?) {           //contains information about the broadcast that was sent.
            Toast.makeText(
                context,
                "Broadcast received",
                Toast.LENGTH_SHORT
            ).show()
    }
}