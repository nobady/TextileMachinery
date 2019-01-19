package com.game.base.utils

import android.util.Log
import com.game.base.BuildConfig

/**
 * Created by Administrator on 2019/1/5.
 */
object LogUtil {

    private const val TAG = "LogUtil"

    fun logV(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, msg)
        }
    }

    fun logI(msg: String){
        if (BuildConfig.DEBUG) {
            Log.i(TAG, msg)
        }
    }
}