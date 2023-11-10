package com.ethanmao.klog.formatter

/**
 * 对堆栈信息进行格式化
 * 这里要考虑是否需要将堆栈信息进行裁剪
 * 先裁剪完成后再进行格式化
 */
class StackTraceFormatter : IFormatter<Array<StackTraceElement>> {

    private var mIsClip = true
    private val clipLevel = 5

    override fun format(data: Array<StackTraceElement>): String {
        if (data.isEmpty()) {
            return ""
        }

        if (mIsClip){
            if (data.size > clipLevel){
             //
//                data = data.copyOfRange(0,clipLevel)
            }
        }

        val strBuilder = StringBuilder(128)

        if (data.size == 1){
            strBuilder.append("\t ➤ ")
            strBuilder.append(data[0])
            strBuilder.append("\n")
            strBuilder.append("\t ▲")
        }else{
            for (index in data.indices){
                // 堆栈信息格式化
                if (index == 0){
                    strBuilder.append("\t ➤ ")
                    strBuilder.append(data[index].toString())
                    strBuilder.append("\n")
                }else if (index != data.size - 1){
                    strBuilder.append("\t - ")
                    strBuilder.append(data[index].toString())
                    strBuilder.append("\n")
                }else{
                    strBuilder.append(data[index].toString())
                    strBuilder.append("\t ▲")
                }
            }
        }
        return strBuilder.toString()
    }

}