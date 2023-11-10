package com.ethanmao.klog.formatter

interface IFormatter<T> {


   fun format(data: T): String

}