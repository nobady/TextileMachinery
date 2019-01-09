package com.game.base.utils

import android.content.Context
import android.content.Intent
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
