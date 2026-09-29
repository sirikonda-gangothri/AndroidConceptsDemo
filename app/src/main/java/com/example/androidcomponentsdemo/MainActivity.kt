package com.example.androidcomponentsdemo

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            this,
            "onCreate()",
            Toast.LENGTH_SHORT
        ).show()

        setContent {
            LifecycleScreen()
        }
    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(
            this,
            "onStart()",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(
            this,
            "onResume()",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(
            this,
            "onPause()",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(
            this,
            "onStop()",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(
            this,
            "onDestroy()",
            Toast.LENGTH_SHORT
        ).show()
    }
}

@Composable
fun LifecycleScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Android Activity Lifecycle Demo"
        )
        Button(onClick = {
            val intent = Intent(
                context,
                SecondActivity::class.java
            )
            context.startActivity(intent)
        }
        ) { Text("Open second Activity") }

        Button(
            onClick = {
                val intent = Intent(
                    context,
                    DemoService::class.java
                )
                context.startService(intent)
            }
        ) {
            Text("Start Service")
        }

        Button(
            onClick = {
                val intent = Intent(
                    context,
                    DemoService::class.java
                )
                context.stopService(intent)

            }
        ) {
            Text("Stop Service")
        }

        Button(
            onClick = {
                val intent = Intent(
                    context,
                    BackgroundDemoService::class.java
                )
                context.startService(intent)

            }
        ) {
            Text("Start background Service")
        }

        Button(
            onClick = {
                val intent = Intent(
                    context,
                    BackgroundDemoService::class.java
                )
                context.stopService(intent)
//context.stopService(intent) ➡ Activity/UI tells the service to stop
//stopSelf()➡ Service tells Android that it wants to stop itself
            }
        ) {
            Text("Stop Background Service")
        }

        Button(
            onClick = {

                val intent = Intent(
                    context,
                    ForegroundDemoService::class.java
                )

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    context.startForegroundService(intent)
                } else {
                    context.startService(intent)
                }
            }
        ) {
            Text("Start Foreground Service")
        }

        Button(
            onClick ={
                val intent= Intent(
                context,
                IntentServiceDemoService::class.java
            )
            context.startService(intent)
        })
            {
            Text("Start Intent Service")
        }

        Button(
            onClick = {
                val intent=Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com")
                )
                context.startActivity(intent)
            }
        ){
            Text("Open Google")
        }
    }
}
