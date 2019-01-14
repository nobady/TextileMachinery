package com.textile.client.utils

import android.content.Context
import android.content.SharedPreferences
import com.textile.client.App

/**
 * Created by Administrator on 2019/1/13.
 */
class SharePrefsHelps (name:String){

    private var spName:String = name
    private var sp: SharedPreferences = AndroidUtils.getCtx().getSharedPreferences(name, Context.MODE_PRIVATE)!!

    constructor():this(COMMON_NAME)

    companion object {
        private val COMMON_NAME = "fangji"
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor = sp.edit()
        editor.putBoolean(key, value)
        editor.commit()
    }
    fun putBooleanNoCommit(key: String, value: Boolean) {
        val editor = sp.edit()
        editor.putBoolean(key, value)
    }

    fun getBoolean(key: String, value: Boolean): Boolean {
        return sp.getBoolean(key, value)
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    fun putString(key: String, value: String) {
        val editor = sp.edit()
        editor.putString(key, value)
        editor.commit()
    }
    fun putStringNoCommit(key: String, value: String) {
        val editor = sp.edit()
        editor.putString(key, value)
    }

    fun getString(key: String, value: String): String {

        return sp.getString(key, value)
    }

    fun getString(key: String): String {
        return getString(key, "")
    }


    fun putInt(key: String, value: Int) {
        val editor = sp.edit()
        editor.putInt(key, value)
        editor.commit()
    }
    fun putIntNoCommit(key: String, value: Int) {
        val editor = sp.edit()
        editor.putInt(key, value)
    }

    fun getInt(key: String, value: Int): Int {
        return sp.getInt(key, value)
    }

    fun getInt(key: String): Int {
        return getInt(key, 0)
    }


    fun putLong(key: String, value: Long) {
        val editor = sp.edit()
        editor.putLong(key, value)
        editor.commit()
    }
    fun putLongNoCommit(key: String, value: Long) {
        val editor = sp.edit()
        editor.putLong(key, value)
    }

    fun getLong(key: String, value: Long): Long {
        return sp.getLong(key, value)
    }

    fun getLong(key: String): Long {
        return getLong(key, 0L)
    }

    fun putFloat(key: String, value: Float) {
        val editor = sp.edit()
        editor.putFloat(key, value)
        editor.commit()
    }
    fun putFloatNoCommit(key: String, value: Float) {
        val editor = sp.edit()
        editor.putFloat(key, value)
    }

    fun getFloat(key: String, value: Float): Float {
        return sp.getFloat(key, value)
    }

    fun getFloat(key: String): Float {
        return getFloat(key, 0f)
    }
    //所以调用putXXXNoCommit的方法，最后都要调用此方法
    fun commit(){
        sp.edit().apply()
    }

}