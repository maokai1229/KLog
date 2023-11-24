package com.ethanmao.klog.formatter

/**
 * 对堆栈信息进行格式化
 * 这里要考虑是否需要将堆栈信息进行裁剪
 * 先裁剪完成后再进行格式化
 */
class StackTraceFormatter : IFormatter<Array<StackTraceElement>> {

    private var mIsClip = true
    private val clipLevel = 5

    fun setClipTrace(isClip : Boolean){
        mIsClip = isClip
    }

    override fun format(data: Array<StackTraceElement>): String {
        if (data.isEmpty()) {
            return ""
        }
        var clipedData =  data
        if (mIsClip){
            if (data.size > clipLevel){
                clipedData = data.copyOfRange(0,clipLevel)
            }
        }

        val strBuilder = StringBuilder(128)

        if (clipedData.size == 1){
            strBuilder.append("\t ➤ ")
            strBuilder.append(clipedData[0])
            strBuilder.append("\n")
            strBuilder.append("\t ▲")
        }else{
            for (index in clipedData.indices){
                // 堆栈信息格式化
                if (index == 0){
                    strBuilder.append("\t ➤ ")
                    strBuilder.append(clipedData[index].toString())
                    strBuilder.append("\n")
                }else if (index != clipedData.size - 1){
                    strBuilder.append("\t - ")
                    strBuilder.append(clipedData[index].toString())
                    strBuilder.append("\n")
                }else{
                    strBuilder.append(clipedData[index].toString())
                    strBuilder.append("\t ▲")
                }
            }
        }
        return strBuilder.toString()
    }

}