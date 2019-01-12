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

fun BaseFragment.toActivityNotFinish(cls: Class<*>) {
    activity?.let {
        val intent = Intent(it, cls)
        it.startActivity(intent)
    }
}

fun BaseActivity.toActivityNotFinish(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

fun BaseFragment.toActivityFinish(cls: Class<*>) {
    activity?.let {
        val intent = Intent(it, cls)
        it.startActivity(intent)
        it.finish()
    }
}

fun BaseActivity.toActivityFinish(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
    finish()
}

fun BaseFragment.toActivityNotFinish(intent: Intent) {
    activity?.startActivity(intent)
}

fun BaseActivity.toActivityNotFinish(intent: Intent) {
    startActivity(intent)
}

fun BaseFragment.toActivityFinish(intent: Intent) {
    activity?.startActivity(intent)
    activity?.finish()
}

fun BaseActivity.toActivityFinish(intent: Intent) {
    startActivity(intent)
    finish()
}

fun BaseFragment.toActivityForResult(cls: Class<*>,requestCode:Int) {
    activity?.let {
        val intent = Intent(it, cls)
        it.startActivityForResult(intent,requestCode)
        it.finish()
    }
}

fun BaseActivity.toActivityForResult(cls: Class<*>,requestCode:Int) {
    val intent = Intent(this, cls)
    startActivityForResult(intent,requestCode)
    finish()
}

fun BaseFragment.toActivityForResult(intent: Intent,requestCode:Int) {
    activity?.startActivityForResult(intent,requestCode)
    activity?.finish()
}

fun BaseActivity.toActivityForResult(intent: Intent,requestCode:Int) {
    startActivityForResult(intent,requestCode)
    finish()
}

