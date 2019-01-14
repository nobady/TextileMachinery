package com.textile.client.mall.ui

import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.listener.CBPageChangeListener
import com.textile.client.R
import kotlinx.android.synthetic.main.adapter_mall_banner.view.*

/**
 * Created by lff on 2019/1/14.
 */
class BannerAdapter constructor(helper: LayoutHelper):DelegateAdapter.Adapter<BannerAdapter.BannerHolder>() {


    private val mHelper = helper
    var imageUrls = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_mall_banner, parent, false)
        return BannerHolder(view)
    }

    override fun getItemCount() = 1

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.mBanner.setPages({ BannerImageHolder() },imageUrls).setOnItemClickListener {

        }.setOnPageChangeListener(object :ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        }).startTurning(2000)
    }

    inner class BannerHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val mBanner:ConvenientBanner<String> = itemView.findViewById(R.id.conBanner)
    }
}