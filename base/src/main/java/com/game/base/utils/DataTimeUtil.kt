package com.game.base.utils

import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Administrator on 2019/1/5.
 */
object DataTimeUtil {

    private const val DATE_TIME = "yyyy-MM-dd"
    private const val DATE_TIME_HOUR = "HH:mm"
    private const val DATE_TIME0 = "yyyy-MM-dd HH:mm"
    private const val DATE_TIME1 = "MM-dd"
    private const val DATE_TIME_MONTH = "MM-dd HH:mm:ss"
    private const val DATE_Calendar = "yyyyMMdd"
    private const val DATE_TIME_MILL = "yyyy-MM-dd HH:mm:ss"
    private const val DATE_TIME_MILL_HOUR_MIN_MILL = "HH:mm:ss"
    private const val T_HOUR = "yyyy-MM-dd'T'HH:mm:ss"

    /**
     * 获取期限名称
     *
     * @param type 1：日 2：周 3：月 4：季度 5：年
     * @return String
     */
    fun getPeriodName(type: Int): String {
        var result = ""
        when (type) {
            1 -> result = "天"
            2 -> result = "周"
            3 -> result = "个月"
            4 -> result = "个季度"
            5 -> result = "年"
        }
        return result
    }

    /**
     * 格式化时间（yyyy-MM-dd）
     *
     * @param dateTime
     * @return
     */
    fun formatDateTime(dateTime: Long): String {
        return formatDateTime(dateTime, DATE_TIME)
    }

    /**
     * 格式化时间（yyyy-MM-dd）
     *
     * @param dateTime
     * @return
     */
    fun formatDateTime0(dateTime: Long): String {
        return formatDateTime(dateTime, DATE_TIME0)
    }

    /**
     * 格式化时间（MM-dd）
     *
     * @param dateTime
     * @return
     */
    fun formatDateTimeMonth(dateTime: Long): String {
        return formatDateTime(dateTime, DATE_TIME1)
    }


    /**
     * 格式化时间（HH-mm）
     *
     * @param dateTime
     * @return
     */
    fun formatDateTimeHour(dateTime: Long): String {
        return formatDateTime(dateTime, DATE_TIME_HOUR)
    }


    /**
     * 格式化时间（HH:mm:mm）
     *
     * @param mill 参数秒
     * @return
     */
    fun formatDateTimeHMM(mill: Long): String {
        return formatDateTime(mill, DATE_TIME_MILL_HOUR_MIN_MILL)
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @param format
     * @return
     */
    fun formatDateTime(dateTime: Long, format: String): String {
        val date = Date(dateTime)
        val simpleDateFormat = SimpleDateFormat(format)
        return simpleDateFormat.format(date)
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @return
     */

    fun formatDateTimeMill(dateTime: Long): String {
        val date = Date(dateTime)
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_MILL)
        return simpleDateFormat.format(date)
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @return
     */

    fun formatDateTimeMMSS(dateTime: Long): String {
        val date = Date(dateTime)
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_MONTH)
        return simpleDateFormat.format(date)
    }

    fun getCurrentDateTime(): String {
        val date = Date(System.currentTimeMillis())
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_MILL)
        return simpleDateFormat.format(date)
    }

    fun getCalendarTime(): String {
        val date = Date(System.currentTimeMillis())
        val simpleDateFormat = SimpleDateFormat(DATE_Calendar)
        return simpleDateFormat.format(date)
    }

    /**
     * 输入yyyy-MM-dd'T'HH:mm:ss
     * 输出: HH:mm
     *
     * @param time
     * @return
     */
    fun formatTime(time: String): String {
        val sdf = SimpleDateFormat(T_HOUR)
        val date = sdf.parse(time)
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_HOUR)
        return simpleDateFormat.format(date)
    }

    /**
     * 返回时间戳
     *
     * @param Time
     * @return
     */
    fun getTimeMill(Time: String): Long {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = format.parse(Time)
        return date.time
    }

    /**
     * 获取 时间间隔 天数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    fun getTimeDistance(beginDate: Date, endDate: Date): Int {
        val beginCalendar = Calendar.getInstance()
        beginCalendar.time = beginDate
        val endCalendar = Calendar.getInstance()
        endCalendar.time = endDate
        val beginTime = beginCalendar.time.time
        val endTime = endCalendar.time.time
        //先算出两时间的毫秒数之差大于一天的天数
        val betweenDays = ((endTime - beginTime) / (1000 * 60 * 60 * 24)).toInt()
        //使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays)
        endCalendar.add(Calendar.DAY_OF_MONTH, -1)//再使endCalendar减去1天
        //比较两日期的DAY_OF_MONTH是否相等
        return if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH)) {
            //相等说明确实跨天了
            betweenDays + 1
        } else {
            //不相等说明确实未跨天
            betweenDays
        }
    }

}