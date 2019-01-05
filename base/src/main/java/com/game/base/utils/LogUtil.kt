package com.game.base.utils

import android.util.Log
import com.game.base.BuildConfig

/**
 * Created by Administrator on 2019/1/5.
 */
object LogUtil {

    private val tag = "LogUtil"

    fun logv(msg:String){
        if (BuildConfig.DEBUG){
            Log.v(tag,msg)
        }
    }
}