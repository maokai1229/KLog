package com.example.klog.core


/**
 * 日志工具的管理器
 *
 */
object KLogManager {

    private var mInited = false
    private var mIsEnabled = true
    private var mDefaultTag = "KLog"

    fun init(isEnable : Boolean,defaultTag : String){
        mIsEnabled = isEnable
        mDefaultTag = defaultTag
        mInited = true
    }


    fun isEnabled(): Boolean {
        return mIsEnabled
    }

    fun getDefaultTag(): String {
        return mDefaultTag
    }
}