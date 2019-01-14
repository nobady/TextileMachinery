package com.textile.client.utils

import android.content.Context

/**
 * Created by lff on 2019/1/14.
 */
object AndroidUtils {

    private var mContext:Context? = null

    fun regCtx(context: Context){
        mContext = context
    }

    fun getCtx() = mContext!!
}