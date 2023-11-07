package com.example.klog

import android.util.Log
import com.example.klog.core.KLogManager
import com.example.klog.core.LogLevel
import java.util.logging.LogManager

/**
 * 供外部调用的类
 * 用法同 android.util.Log
 * 与 android.util.Log 不同在于，可以直接传入 Object 打印
 * 当然自动拆装箱，也会带来一些性能损耗
 */
class KLog {

    fun w(tag: String,vararg msg: Any) {
        log(LogLevel.WARN, tag, msg)
    }

    fun w(vararg msg: Any) {
        log(LogLevel.WARN, KLogManager.getDefaultTag(), msg)
    }

    fun i(vararg msg: Any) {
        log(LogLevel.INFO, KLogManager.getDefaultTag(), msg)
    }

    fun i(tag: String,vararg msg: Any) {
        log(LogLevel.INFO, tag, msg)
    }

    fun d(vararg msg: Any) {
        log(LogLevel.DEBUG, KLogManager.getDefaultTag(), msg)
    }

    fun d(tag: String,vararg msg: Any) {
        log(LogLevel.DEBUG, tag, msg)
    }

    fun e(tag: String,vararg msg: Any) {
        log(LogLevel.ERROR, tag, msg)
    }

    fun e(vararg msg: Any) {
        log(LogLevel.ERROR, KLogManager.getDefaultTag(), msg)
    }


    private fun log(logLevel: @LogLevel Int, tag: String,vararg msg: Any) {
        if (!KLogManager.isEnabled()){
            return
        }

        val stringBuilder = StringBuilder()
        for (obj in msg){
            stringBuilder.append(obj.toString())
            stringBuilder.append(";")
        }

        Log.println(logLevel, tag, stringBuilder.toString())

    }

}