package com.game.base.utils

import android.content.Context
import android.content.Intent
import android.util.TypedValue
import android.widget.Toast
import com.game.base.mvp.BaseActivity
import com.game.base.mvp.BaseFragment

/**
 * Created by bo on 2019/1/6.
 */
fun BaseFragment.toast(msg: String) = Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()

fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun Context.toast(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()

fun BaseFragment.toActivity(cls: Class<*>) {
    val intent = Intent(activity, cls)
    activity?.startActivity(intent)
}

fun BaseActivity.toActivity(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

fun Context.dip2Px(dip: Int): Int {
    val density = resources.getDisplayMetrics().density
    return (dip.toFloat() * density + 0.5f).toInt()
}

fun Context.px2dip(px: Int): Int {
    val density = resources.getDisplayMetrics().density
    return (px.toFloat() / density + 0.5f).toInt()
}

fun Context.sp2px(sp: Int): Int {
    return (TypedValue.applyDimension(2, sp.toFloat(), resources.getDisplayMetrics()) + 0.5f).toInt()
}
