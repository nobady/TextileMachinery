package com.textile.client.shop_car.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.game.base.image.ImageUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.shop_car.model.ShopCartModel
import com.textile.client.utils.RecycerItemCheckListener
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.adapter_item_shop_car.view.*

/**
 * Created by lff on 2019/1/21.
 */
class ShopCarAdapter(helper: LayoutHelper) : DelegateAdapter.Adapter<ShopCarAdapter.ShopCarViewHolder>() {

    private val mHelper = helper
    var shopCartList: List<ShopCartModel.ListData> = ArrayList()
    var itemClickListener:RecyclerItemClickListener<ShopCartModel.ListData>? = null
    var itemCheckListener:RecycerItemCheckListener<ShopCartModel.ListData>? = null
    var selectShopCartList:List<ShopCartModel.ListData> = ArrayList()

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
        ImageUtil.displayImage(
            holder.itemView.context,
            holder.itemView.iv_shopCar_adapter_icon,
            shopCartList[position].imageUrl,
            R.mipmap.ic_launcher
        )
        holder.itemView.cb_shopCar_adapter_choose.isEnabled = false
        holder.itemView.tv_shopCar_adapter_num.text = "${shopCartList[position].amount}"
        holder.itemView.cb_shopCar_adapter_choose.isChecked = shopCartList[position].isChecked
        holder.itemView.tv_shopCar_adapter_minus.setOnClickListener {
            if (shopCartList[position].amount==1){
                it.context.toast(R.string.not_minus_shop_car)
            }else{
                shopCartList[position].amount--
                shopCartList[position].type=1
                itemClickListener?.onItemClick(shopCartList[position],position)
                notifyItemChanged(position)
            }
        }

        holder.itemView.tv_shopCar_adapter_plus.setOnClickListener {
            shopCartList[position].amount++
            shopCartList[position].type=0
            itemClickListener?.onItemClick(shopCartList[position],position)
            notifyItemChanged(position)
        }
        holder.itemView.setOnClickListener {
            holder.itemView.cb_shopCar_adapter_choose.isChecked = !holder.itemView.cb_shopCar_adapter_choose.isChecked
            if (holder.itemView.cb_shopCar_adapter_choose.isChecked){
                (selectShopCartList as ArrayList).add(shopCartList[position])
                shopCartList[position].isChecked = true
            }else{
                (selectShopCartList as ArrayList).remove(shopCartList[position])
                shopCartList[position].isChecked = false
            }
            notifyItemChanged(position)
            itemCheckListener?.onChecked(shopCartList[position],position)
        }
    }

    fun setSelectAll(checked: Boolean) {
        shopCartList.forEach {
            it.isChecked = checked
        }
        if (checked){
            selectShopCartList = shopCartList
        }else{
            selectShopCartList = ArrayList()
        }
        notifyDataSetChanged()
    }

    inner class ShopCarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}
