package com.ethanmao.klog.printer

import com.ethanmao.klog.core.LogLevel


/**
 * 日志打印的接口
 */
interface ILogPrinter {

    fun print(logLevel: @LogLevel Int,tag: String, msg: Any)

}