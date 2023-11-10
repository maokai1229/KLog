package com.ethanmao.klog.formatter

class ThreadFormatter : IFormatter<Thread> {
    override fun format(thread: Thread): String {
        return "\nThread: ${thread.name}".plus("\n")
    }
}