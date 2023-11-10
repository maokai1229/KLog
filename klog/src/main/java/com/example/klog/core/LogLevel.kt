package com.example.klog.core

import android.util.Log

/**
 * 日志等级注解
 */
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.SOURCE)
annotation class LogLevel{

    companion object{
        const val VERBOSE = Log.VERBOSE
        const val INFO = Log.INFO
        const val DEBUG = Log.DEBUG
        const val WARN = Log.WARN
        const val ERROR = Log.ERROR
    }

}
