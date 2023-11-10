package com.ethanmao.klog.printer

import android.util.Log

/**
 * 控制台日志打印
 * 就是标准的 LogCat 输出
 */
class ConsoleLogPrinter : ILogPrinter {

    override fun print(logLevel: Int, tag: String, msg: Any) {
        Log.println(logLevel,tag, msg.toString())
    }


}