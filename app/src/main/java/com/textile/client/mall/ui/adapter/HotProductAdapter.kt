package com.textile.client.mall.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.game.base.image.ImageUtil
import com.textile.client.R
import com.textile.client.mall.model.HotModel
import kotlinx.android.synthetic.main.adapter_item_hot.view.*

/**
 * Created by lff on 2019/2/12.
 */
class HotProductAdapter constructor(helper: LayoutHelper,context: Context):DelegateAdapter.Adapter<HotProductAdapter.HotProductHolder>() {

    private val mHelper = helper
    var hotList:List<HotModel.ListData> = ArrayList()
    private val mContext = context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_hot, parent, false)
        return HotProductHolder(view)
    }

    override fun getItemCount() = hotList.size

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: HotProductHolder, position: Int) {
        val listData = hotList[position]
        ImageUtil.displayImage(mContext,holder.itemView.iv_hot_adapter,listData.imageUrl,R.mipmap.default_banner)
        holder.itemView.tv_hot_adapter_name.text = listData.name
        holder.itemView.tv_hot_adapter_style.text = listData.modeName
        holder.itemView.tv_hot_adapter_price.text = mContext.getString(R.string.hot_price_text,listData.price)
        holder.itemView.iv_hot_adapter_car.setOnClickListener {

        }
    }

    inner class HotProductHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}