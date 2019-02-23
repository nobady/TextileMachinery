package com.textile.client.shop_car.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.textile.client.R
import com.textile.client.shop_car.model.ShopCartModel

/**
 * Created by admin on 2019/2/21.
 */
class ConfirmOrderAdapter(helper:LayoutHelper):DelegateAdapter.Adapter<ConfirmOrderAdapter.ConfirmOrderHolder>() {

    private val mHelper = helper
    var orderList:ArrayList<ShopCartModel.ListData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmOrderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_confirm_order_item, parent, false)
        return ConfirmOrderHolder(view)
    }

    override fun getItemCount() = orderList.size

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: ConfirmOrderHolder, position: Int) {
    }

    inner class ConfirmOrderHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}