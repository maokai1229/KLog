package com.ethanmao.klog.core


/**
 * 日志打印的接口
 */
interface ILogPrinter {

    fun print(tag: String, msg: Any)

}