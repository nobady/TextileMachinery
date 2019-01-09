package com.game.base.utils

import java.util.regex.Pattern

/**
 * 正则
 * Created by Administrator on 2019/1/9.
 */
object PatternUtil {
    /**
     * 判断手机号
     */
    fun checkPhoneNum(num: String): Boolean{
        val regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(14[5-9])|(166)|(19[8,9])|)\\d{8}$"
        val p = Pattern.compile(regExp)
        val m = p.matcher(num)
        return m.matches()
    }
}