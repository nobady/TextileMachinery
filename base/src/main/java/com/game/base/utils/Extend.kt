package com.game.base.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import com.game.base.mvp.BaseFragment

/**
 * Created by bo on 2019/1/6.
 */
fun BaseFragment.toast(msg: String) = ToastManager.showShortToast(msg)

fun Context.toast(msg: String) = ToastManager.showShortToast(msg)
