package com.textile.client.mall.ui.adapter

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
import com.textile.client.R
import com.textile.client.mall.model.BannerModel

/**
 * Created by lff on 2019/1/14.
 */
class BannerAdapter constructor(helper: LayoutHelper) : DelegateAdapter.Adapter<BannerAdapter.BannerHolder>() {

    private val mHelper = helper
    var imageUrls: List<BannerModel.ListData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_mall_banner, parent, false)
        return BannerHolder(view)
    }

    override fun getItemCount() = if (imageUrls.isEmpty()) 0 else 1

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        val banner = holder.mBanner.setPages({ BannerImageHolder() }, imageUrls).setOnItemClickListener {

        }.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                holder.indexTv.text = "${position + 1}/${imageUrls.size}"
            }
        })
        holder.indexTv.text = "${position + 1}/${imageUrls.size}"
        holder.indexTv.visibility = View.VISIBLE
        holder.searchView.visibility = View.VISIBLE
        if (banner.isTurning) {
            banner.stopTurning()
        }
        banner.startTurning(2000)
    }

    inner class BannerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mBanner: ConvenientBanner<BannerModel.ListData> = itemView.findViewById(R.id.conBanner)
        val indexTv: TextView = itemView.findViewById(R.id.tv_banner_index)
        val searchView: LinearLayout = itemView.findViewById(R.id.ll_banner_search)
    }
}