package com.textile.client.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Administrator on 2019/1/13.
 */
class SharePrefsHelps (context: Context,name:String){

    private var spName:String = name
    private var sp: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    constructor(context: Context):this(context, COMMON_NAME)

    companion object {
        private val COMMON_NAME = "fangji"
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {

        val editor = sp.edit()
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun getBoolean(context: Context, key: String, value: Boolean): Boolean {
        return sp.getBoolean(key, value)
    }

    fun getBoolean(context: Context, key: String): Boolean {
        return getBoolean(context, key, false)
    }

    fun putString(context: Context, key: String, value: String) {
        val editor = sp.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(context: Context, key: String, value: String): String {

        return sp.getString(key, value)
    }

    fun getString(context: Context, key: String): String {
        return getString(context, key, "")
    }


    fun putInt(context: Context, key: String, value: Int) {
        val editor = sp.edit()
        editor.putInt(key, value)
        editor.commit()
    }

    fun getInt(context: Context, key: String, value: Int): Int {
        return sp.getInt(key, value)
    }

    fun getInt(context: Context, key: String): Int {
        return getInt(context, key, 0)
    }


    fun putLong(context: Context, key: String, value: Long) {
        val editor = sp.edit()
        editor.putLong(key, value)
        editor.commit()
    }

    fun getLong(context: Context, key: String, value: Long): Long {
        return sp.getLong(key, value)
    }

    fun getLong(context: Context, key: String): Long {
        return getLong(context, key, 0L)
    }

    fun putFloat(context: Context, key: String, value: Float) {
        val editor = sp.edit()
        editor.putFloat(key, value)
        editor.commit()
    }

    fun getFloat(context: Context, key: String, value: Float): Float {

        return sp.getFloat(key, value)
    }

    fun getFloat(context: Context, key: String): Float {
        return getFloat(context, key, 0f)
    }
}