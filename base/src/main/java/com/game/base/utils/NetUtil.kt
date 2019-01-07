package com.game.base.utils

import android.content.ComponentName
import android.content.Intent
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo



/**
 * Created by Administrator on 2019/1/5.
 */
object NetUtil {

    /**
     * 判断网络是否连接
     *
     * @return
     */
    fun isConnected(context: Context): Boolean {

        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val info = connectivity.activeNetworkInfo
            if (null != info) {
                return info.isConnected
            }
        return false
    }

    /**
     * 判断是否是wifi连接
     */
    fun isWifi(context: Context): Boolean {
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI

    }

    /**
     * 打开网络设置界面
     */
    fun openSetting(activity: Activity) {
        val intent = Intent("/")
        val cm = ComponentName(
            "com.android.settings",
            "com.android.settings.WirelessSettings"
        )
        intent.component = cm
        intent.action = "android.intent.action.VIEW"
        activity.startActivityForResult(intent, 0)
    }
}