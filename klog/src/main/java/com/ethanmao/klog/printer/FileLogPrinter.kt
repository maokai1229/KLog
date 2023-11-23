package com.ethanmao.klog.printer

import android.app.Application
import com.ethanmao.klog.core.LogLevel
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date

class FileLogPrinter(val application: Application) : ILogPrinter {
    // 日志文件格式
    private val logfile: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
    private val mFileDirName = "KLog"
    private var mFile :  File
    private val mLogSdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")


    init {
        val fileDir = File(application.getFilesDir(),mFileDirName)
        if (!fileDir.exists()) {
            fileDir.mkdirs()
        }

        val fileName = generateFileName()
        // 是否能一天只写一份文件
        mFile = File(fileName)
        // 如果当天已经存在了有,就不去新建文件了
        if (!mFile.exists()){
            mFile.createNewFile()
        }
    }


    // 根据当天的日期作为文件名,如果有同样的文件名,就不去新建了
    override fun print(logLevel: Int, tag: String, msg: String) {
        // 写文件
        val needWriteMessage = generateFileLogMessage(logLevel,tag,msg)
        try {
            // 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
            val filerWriter =  FileWriter(mFile, true)
            val bufWriter =  BufferedWriter(filerWriter)
            bufWriter.write(needWriteMessage)
            bufWriter.newLine()
            bufWriter.close()
            filerWriter.close()
        } catch (e : IOException) {
            e.printStackTrace();
        }
    }

    private fun generateFileLogMessage(logLevel: Int, tag: String, msg: String): String {
        val stringBuilder  = StringBuilder()
        val dateNow = Date()
        val timeNow =  mLogSdf.format(dateNow)
        stringBuilder.append(timeNow)
        stringBuilder.append("\t")

        when(logLevel){
            LogLevel.VERBOSE->{
                stringBuilder.append("v ")
            }
            LogLevel.INFO->{
                stringBuilder.append("i ")

            }
            LogLevel.WARN->{
                stringBuilder.append("w ")

            }
            LogLevel.DEBUG->{
                stringBuilder.append("d ")

            }
            LogLevel.ERROR->{
                stringBuilder.append("e ")
            }

        }
        stringBuilder.append(tag)
        stringBuilder.append("\t")
        stringBuilder.append(msg)
        return stringBuilder.toString()
    }

    private fun generateFileName() : String {
        val date = Date()
       return application.getFilesDir().path.toString().plus(logfile.format(date)).plus("_Log.txt")
    }
}