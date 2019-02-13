package com.textile.client.mall.ui.adapter

import android.content.Context
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.bigkoo.convenientbanner.ConvenientBanner
import com.game.base.image.ImageUtil
import com.game.base.utils.dip2Px
import com.textile.client.R
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.ui.adapter.BDAdapter.BDHolder
import kotlinx.android.synthetic.main.adapter_mall_bd.view.*

/**
 * Created by lff on 2019/1/14.
 */
class BDAdapter constructor(helper: LayoutHelper):DelegateAdapter.Adapter<BDHolder>() {

    private val mHelper = helper
    var imageUrls:List<BannerModel.ListData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BDHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_mall_bd, parent, false)
        return BDHolder(view)
    }

    override fun getItemCount() = if (imageUrls.isEmpty()) 0 else 1

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: BDHolder, position: Int) {
        ImageUtil.displayImage(holder.itemView.context,holder.itemView.iv_bd_adapter,imageUrls[0].image,R.mipmap.default_banner)
    }

    inner class BDHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}