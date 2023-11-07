package com.example.klog.formatter

class StackTraceFormatter : IFormatter<Array<StackTraceElement>> {

    override fun format(data: Array<StackTraceElement>): String {
        if (data.isEmpty()) {
            return ""
        }

        val strBuilder = StringBuilder()

        if (data.size == 1){
            strBuilder.append("/t ➤")
            strBuilder.append(data[0])
            strBuilder.append("/n")
            strBuilder.append("/t ▲")
        }else{
            for (index in data.indices){
                // 堆栈信息格式化
                if (index == 0){
                    strBuilder.append("/t ➤")
                    strBuilder.append(data[index])
                    strBuilder.append("/n")
                }else if (index != data.size - 1){
                    strBuilder.append("/t - ")
                    strBuilder.append(data[index])
                    strBuilder.append("/n")
                }else{
                    strBuilder.append(data[index])
                    strBuilder.append("/t ▲")
                }
            }
        }
        return strBuilder.toString()
    }

}