package com.dirox.test

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyReceiver.ConnectivityReceiverListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(MyReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
        MyReceiver.connectivityReceiverListener = this
    }

    override fun onResume() {
        super.onResume()
        MyReceiver.connectivityReceiverListener = this
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if(isConnected){
            Toast.makeText(this, "Wifi connected", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Wifi disconnected", Toast.LENGTH_LONG).show()
        }
    }


}
