package com.game.base.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/**
 * Created by lff on 2018/12/21.
 */
object ImageUtil {

    fun displayImage(context: Context,imageView: ImageView,resId:Int,defaultResId:Int){
        val options = RequestOptions().placeholder(defaultResId).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH)
        Glide.with(context).load(resId).apply(options).into(imageView)
    }
}