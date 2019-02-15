package com.textile.client.forum.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.game.base.image.ImageUtil
import com.textile.client.R
import com.textile.client.ShowBigImageActivity

class ImageAdapter(val data: List<String>) : RecyclerView.Adapter<ImageAdapter.ImageHolder>() {
    private lateinit var mContext: Context
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ImageHolder {
        mContext = p0.context
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.item_image_view, p0, false)
        return ImageHolder(inflate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ImageHolder, p1: Int) {
        ImageUtil.displayImage(mContext, p0.imageView, data[p1], R.drawable.default_header)
        p0.imageView.setOnClickListener {
            val intent = Intent(mContext,ShowBigImageActivity::class.java)
            intent.putExtra("image_url", data[p1])
            mContext.startActivity(intent)
        }
    }

    inner class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.mItemImageView)
    }
}