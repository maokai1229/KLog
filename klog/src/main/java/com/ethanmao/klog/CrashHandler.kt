package com.ethanmao.klog

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build

/**
 *  崩溃信息处理
 *  崩溃发生时,复制到系统剪切板
 *  用于排查测试阶段发生的 Crash
 */
class CrashHandler (val application: Application): Thread.UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        // 获取崩溃信息
        val crashInfo = getCrashInfo(throwable)
        // 将崩溃信息复制到剪贴板
        copyToClipboard(crashInfo)
        // 退出应用
        System.exit(1)
    }

    private fun getCrashInfo(throwable: Throwable): String {
        val sb = StringBuilder()
        // 设备信息
        sb.append("设备型号：").append(Build.MODEL).append("\n")
        sb.append("操作系统版本：").append(Build.VERSION.RELEASE).append("\n")
        // 崩溃堆栈信息
        sb.append("崩溃堆栈信息：").append(throwable.stackTraceToString()).append("\n")
        return sb.toString()
    }

    private fun copyToClipboard(crashInfo: String) {
        // 获取剪贴板管理器
        val clipboardManager = application.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        // 创建一个 ClipData 对象
        val clipData = ClipData.newPlainText("crash_info", crashInfo)

        // 将 ClipData 对象设置到剪贴板
        clipboardManager.setPrimaryClip(clipData)
    }
}