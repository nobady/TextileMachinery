package com.textile.client.shop_car.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.game.base.image.ImageUtil
import com.textile.client.R
import com.textile.client.shop_car.model.ShopCartModel
import kotlinx.android.synthetic.main.adapter_item_shop_car.view.*

/**
 * Created by lff on 2019/1/21.
 */
class ShopCarAdapter(helper: LayoutHelper): DelegateAdapter.Adapter<ShopCarAdapter.ShopCarViewHolder>() {

    private val mHelper = helper
     var shopCartList:List<ShopCartModel.ListData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopCarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_shop_car, parent, false)
        return ShopCarViewHolder(view)
    }

    override fun getItemCount() = shopCartList.size

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: ShopCarViewHolder, position: Int) {
        holder.itemView.tv_shopCar_adapter_name.text = shopCartList[position].name
        holder.itemView.tv_shopCar_xinghao.text = shopCartList[position].model
        holder.itemView.tv_shopCar_adapter_money.text = shopCartList[position].money
        ImageUtil.displayImage(holder.itemView.context,holder.itemView.iv_shopCar_adapter_icon,shopCartList[position].imageUrl,R.mipmap.ic_launcher)
        holder.itemView.tv_shopCar_adapter_num.text = "$position"
    }

    inner class ShopCarViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){}
}
