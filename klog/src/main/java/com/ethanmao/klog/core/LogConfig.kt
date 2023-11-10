package com.ethanmao.klog.core



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
    private var mPrinters = mutableListOf<ILogPrinter>()

    constructor(isDebug: Boolean, enableThreadInfo: Boolean, enableStackInfo: Boolean){
        mIsDebug = isDebug
        mEnableThreadInfo = enableThreadInfo
        mEnableStackInfo = enableStackInfo
        initPrinter()
    }

    private fun initPrinter() {
//        if (mEnableStackInfo){
//            mPrinters.add()
//        }
//        if (mEnableThreadInfo){
//            mPrinters.add()
//        }
    }


    fun isDebug() : Boolean{
        return mIsDebug
    }

}