package com.example.klog.formatter

interface IFormatter<T> {


   fun format(data: T): String

}