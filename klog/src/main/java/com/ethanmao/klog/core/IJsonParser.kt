package com.ethanmao.klog.core


/**
 * Json 解析
 */
interface IJsonParser {
    fun toJson(obj: Any): String

}