package com.example.klog.core

import com.google.gson.Gson


/**
 * 日志工具的管理器
 *
 */
object KLogManager {

    private var mInited = false
    private var mDefaultTag = "KLog"
    private lateinit var mConfig : LogConfig
    private var mPrinters = mutableListOf<ILogPrinter>()
    private var mJsonParse = Gson()

    fun init(defaultTag : String,config: LogConfig){
        mDefaultTag = defaultTag
        init(config)
    }

    fun init(config: LogConfig){
        mConfig = config
        mInited = true
    }

    fun getDefaultTag(): String {
        return mDefaultTag
    }

    fun getConfig() : LogConfig{
        if (!mInited){
            // todo 未初始化是直接抛异常还是怎么
         }
        return mConfig
    }

    fun  getParser() : Gson{
        return mJsonParse
    }
}