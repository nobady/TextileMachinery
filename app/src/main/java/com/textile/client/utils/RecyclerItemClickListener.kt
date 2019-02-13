package com.textile.client.utils

/**
 * Created by lff on 2019/2/13.
 */
interface RecyclerItemClickListener<T> {
    fun onItemClick(t:T,position:Int)
}