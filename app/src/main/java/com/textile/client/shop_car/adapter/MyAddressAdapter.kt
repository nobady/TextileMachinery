package com.textile.client.shop_car.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.textile.client.R
import com.textile.client.shop_car.model.MyAddressModel
import kotlinx.android.synthetic.main.adapter_item_my_address.view.*

/**
 * Created by admin on 2019/2/26.
 */
class MyAddressAdapter(context: Context,layoutHelper: LayoutHelper):DelegateAdapter.Adapter<MyAddressAdapter.MyAddressViewHolder>() {


    var dataList:List<MyAddressModel> = ArrayList()
    private val mLayoutHelper = layoutHelper
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAddressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_my_address, parent, false)
        return MyAddressViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onCreateLayoutHelper() = mLayoutHelper

    override fun onBindViewHolder(holder: MyAddressViewHolder, position: Int) {
        val myAddressModel = dataList[position]
        holder.itemView.tv_adapter_address_people.text = mContext.getString(R.string.address_receiver_people,myAddressModel.receiver)
        holder.itemView.tv_adapter_address_phone.text = myAddressModel.phone
        if (position==0){
            val foregroundColorSpan = ForegroundColorSpan(mContext.resources.getColor(R.color.red))
            val backgroundColorSpan = BackgroundColorSpan(mContext.resources.getColor(R.color.grey))
            val spannableStringBuilder = SpannableStringBuilder()
            spannableStringBuilder.append(mContext.getString(R.string.default_address_text),foregroundColorSpan, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableStringBuilder.setSpan(backgroundColorSpan,0,spannableStringBuilder.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableStringBuilder.append(mContext.getString(R.string.shouhuo_address,myAddressModel.address))
            holder.itemView.tv_adapter_address_address.text = spannableStringBuilder
        }else{
            holder.itemView.tv_adapter_address_address.text = mContext.getString(R.string.shouhuo_address,myAddressModel.address)
        }
    }

    inner class MyAddressViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}