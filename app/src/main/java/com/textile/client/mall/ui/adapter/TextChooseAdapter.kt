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
import com.textile.client.login.model.UserPrefs
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.BrandModel
import com.textile.client.mall.ui.adapter.BDAdapter.BDHolder
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.adapter_mall_bd.view.*
import kotlinx.android.synthetic.main.adapter_mall_text.view.*

/**
 * Created by lff on 2019/1/14.
 */
class TextChooseAdapter constructor(helper: LayoutHelper):DelegateAdapter.Adapter<TextChooseAdapter.TextHolder>() {

    private val mHelper = helper
    var brandList:List<BrandModel> = ArrayList()

    var itemClickListener:RecyclerItemClickListener<BrandModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_mall_text, parent, false)
        return TextHolder(view)
    }

    override fun getItemCount() = brandList.size

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: TextHolder, position: Int) {
        if (UserPrefs.getInstance.getLanguage()==1){
            holder.itemView.tv_adapter_text.text = brandList[position].name
        }else{
            holder.itemView.tv_adapter_text.text = brandList[position].ename
        }

        if (brandList[position].isCheck){
            holder.itemView.iv_adapter_check.visibility = View.VISIBLE
        }else{
            holder.itemView.iv_adapter_check.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            resetCheckStatus(position)
            notifyDataSetChanged()
            itemClickListener?.onItemClick(brandList[position],position)
        }
    }

    private fun resetCheckStatus(position: Int){
        brandList.forEach { it.isCheck = false }
        brandList[position].isCheck =true
    }

    inner class TextHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}