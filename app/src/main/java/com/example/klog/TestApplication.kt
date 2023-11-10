package com.example.klog

import android.app.Application
import com.ethanmao.klog.core.KLogManager
import com.ethanmao.klog.core.LogConfig

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 初始化 KLog
        val config = LogConfig(true, true, true)
        KLogManager.init(config)
    }
}