package com.example.androidcomponentsdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class StaticBroadcastReceiver : BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d(
            "StaticBroadcastReceiver",
            "onReceive() called: ${intent?.action}"
        )

        if(intent!=null && intent.action==Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val isAirplaneModeOn=intent.getBooleanExtra("state",false)

            Log.d(
                "StaticBroadcastReceiver",
                "Airplane Mode: $isAirplaneModeOn"
            )

            if(isAirplaneModeOn){
                Toast.makeText(
                    context,
                    "Airplane Mode On",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    context,
                    "Airplane Mode On",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}