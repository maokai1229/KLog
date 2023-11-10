package com.ethanmao.klog.core

import com.ethanmao.klog.printer.ILogPrinter


/**
 * 日志工具配置类
 */
class LogConfig {
    // 日志开关, debug 做打印,release 环境关闭
    private var mIsDebug  = true
    // 是否需要打印线程信息: 线程ID ,是否主线程
    private var mEnableThreadInfo = true
    // 是否打印堆栈信息
    private var mEnableStackInfo = true
    private var mIsClipStackTraceElement = true

    constructor(isDebug: Boolean, enableThreadInfo: Boolean, enableStackInfo: Boolean,clip : Boolean){
        mIsDebug = isDebug
        mEnableThreadInfo = enableThreadInfo
        mEnableStackInfo = enableStackInfo
        mIsClipStackTraceElement = clip
    }


    fun isDebug() : Boolean{
        return mIsDebug
    }
    fun isEnableThreadInfo() : Boolean{
        return mEnableThreadInfo
    }
    fun isEnableStackInfo() : Boolean{
        return mEnableStackInfo
    }

}