package com.example.klog

import android.app.Activity
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvTest = findViewById<Button>(R.id.bt_test)
        tvTest.setOnClickListener {
            KLog.d("First Log","testing")
        }
    }

}