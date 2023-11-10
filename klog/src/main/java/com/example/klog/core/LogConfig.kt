package com.example.klog.core

/**
 * 日志工具配置类
 */
class LogConfig {
    // 日志开关, debug 做打印,release 环境关闭
    private var isDebug  = true
    // 是否需要打印线程信息: 线程ID ,是否主线程
    private var enableThreadInfo = true
    // 是否打印堆栈信息
    private var enableStackInfo = true

    private var printers = mutableListOf<ILogPrinter>()


    fun isDebug() : Boolean{
        return isDebug
    }



}