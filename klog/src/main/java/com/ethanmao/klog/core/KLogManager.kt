package com.ethanmao.klog.core

import android.app.Application
import com.ethanmao.klog.formatter.StackTraceFormatter
import com.ethanmao.klog.formatter.ThreadFormatter
import com.ethanmao.klog.printer.ConsoleLogPrinter
import com.ethanmao.klog.CrashHandler
import com.ethanmao.klog.printer.ILogPrinter


/**
 * 日志工具的管理器
 *
 */
object KLogManager {

    private var mInited = false
    private var mDefaultTag = "KLog"
    private lateinit var mConfig : LogConfig
    private var mPrinters = mutableListOf<ILogPrinter>()
    private var mJsonParse : IJsonParser = JsonParserImpl()
    private val mThreadFormatter = ThreadFormatter()
    private val mStackTraceFormatter = StackTraceFormatter()

    fun init(application: Application,defaultTag : String,config: LogConfig){
        mDefaultTag = defaultTag
        init(application,config)
    }

    fun init(application: Application,config: LogConfig){
        mConfig = config
        mInited = true
        initPrinter()
        // 抓取崩溃信息到剪切板
        if (mConfig.isDebug()){
            Thread.setDefaultUncaughtExceptionHandler(CrashHandler(application))
        }
    }

    private fun initPrinter() {
        mPrinters.add(ConsoleLogPrinter())
    }

    fun getDefaultTag(): String {
        return mDefaultTag
    }

    fun getConfig() : LogConfig {
        if (!mInited){
            // todo 未初始化是直接抛异常还是怎么
         }
        return mConfig
    }

    fun  getParser() : IJsonParser{
        return mJsonParse
    }

    fun getPrinters() : List<ILogPrinter>{
        return mPrinters
    }

    fun getThreadFormatter() : ThreadFormatter{
        return mThreadFormatter
    }

    fun getStackTraceFormatter() : StackTraceFormatter{
       return mStackTraceFormatter
    }
}