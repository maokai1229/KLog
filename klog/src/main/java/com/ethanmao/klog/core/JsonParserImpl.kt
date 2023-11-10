package com.ethanmao.klog.core

import com.google.gson.Gson

class JsonParserImpl : IJsonParser {

    private val mGson = Gson()

    override fun toJson(obj: Any): String {
        return mGson.toJson(obj)
    }


}