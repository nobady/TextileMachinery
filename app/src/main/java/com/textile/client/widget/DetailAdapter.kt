package com.textile.client.widget

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.game.base.image.ImageUtil
import com.textile.client.R

//class DetailAdapter : PagerAdapter() {
//    private lateinit var data: ArrayList<String>
//
//    fun setUrls(urls: ArrayList<String>) {
//        data = urls
//    }
//
//    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
//        return view == `object` as View
//    }
//
//    override fun getCount(): Int {
//        return data.size
//    }
//
//    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
//        return getViewByUrl(data[position], container?.context!!)
//    }
//
//    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
//        container?.removeView(`object` as View)
//    }
//
//    private fun getViewByUrl(url: String, context: Context): Any {
//        return if (url.endsWith(".mp4")) {
//            val surfaceView = SurfaceView(context)
//
//        } else {
//            val imageView = ImageView(context)
//            ImageUtil.displayImage(context, imageView, url, R.drawable.default_header)
//            imageView
//        }
//    }
//}