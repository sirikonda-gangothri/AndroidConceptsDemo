package com.example.androidcomponentsdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryBroadcastReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null && intent.action == Intent.ACTION_BATTERY_CHANGED) {
            val level = intent.getIntExtra(
                "level",
                -1
            )

            val scale = intent.getIntExtra(
                "scale",
                -1
            )

            if (level != -1 && scale != -1 && scale > 0) {
                val batteryPercentage = level * 100 / scale

                Toast.makeText(
                    context,
                    "Battery: $batteryPercentage",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}