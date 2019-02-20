package com.textile.client.utils

/**
 * Created by lff on 2019/2/19.
 */
interface RecycerItemCheckListener<T> {
    fun onChecked(t:T,position:Int)
}