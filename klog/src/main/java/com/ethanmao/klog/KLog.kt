package com.ethanmao.klog

import android.util.Log
import com.ethanmao.klog.core.KLogManager
import com.ethanmao.klog.core.LogLevel
import java.util.logging.LogManager

/**
 * 供外部调用的类
 * 用法同 android.util.Log
 * 与 android.util.Log 不同在于，可以直接传入 Object 打印
 * 当然自动拆装箱，也会带来一些性能损耗
 */
object KLog {

    fun v(tag: String,msg: Any) {
        log(LogLevel.VERBOSE, tag, msg)
    }

    fun v(msg: Any) {
        log(LogLevel.VERBOSE, KLogManager.getDefaultTag(), msg)
    }

    fun w(tag: String,msg: Any) {
        log(LogLevel.WARN, tag, msg)
    }

    fun w(msg: Any) {
        log(LogLevel.WARN, KLogManager.getDefaultTag(), msg)
    }

    fun i(msg: Any) {
        log(LogLevel.INFO, KLogManager.getDefaultTag(), msg)
    }

    fun i(tag: String, msg: Any) {
        log(LogLevel.INFO, tag, msg)
    }

    fun d(msg: Any) {
        log(LogLevel.DEBUG, KLogManager.getDefaultTag(), msg)
    }

    fun d(tag: String,msg: Any) {
        log(LogLevel.DEBUG, tag, msg)
    }

    fun e(tag: String,msg: Any) {
        log(LogLevel.ERROR, tag, msg)
    }

    fun e(msg: Any) {
        log(LogLevel.ERROR, KLogManager.getDefaultTag(), msg)
    }


    private fun log(logLevel: @LogLevel Int, tag: String, msg: Any) {
        if (KLogManager.getConfig() == null
            || !KLogManager.getConfig().isDebug()){
            return
        }

        val stringBuilder = StringBuilder()
        stringBuilder.append(KLogManager.getParser().toJson(msg))
        stringBuilder.append(";")

        // 如果需要打印线程信息
        if (KLogManager.getConfig().isEnableThreadInfo()){
            stringBuilder.append(KLogManager.getThreadFormatter().format(Thread.currentThread()))
        }
        // 如果需要打印堆栈信息
        if (KLogManager.getConfig().isEnableStackInfo()){
            stringBuilder.append(KLogManager.getStackTraceFormatter().format(Throwable().stackTrace))
        }
        // 遍历 Printer
        KLogManager.getPrinters().forEach {
            it.print(logLevel, tag, stringBuilder.toString())
        }}

}