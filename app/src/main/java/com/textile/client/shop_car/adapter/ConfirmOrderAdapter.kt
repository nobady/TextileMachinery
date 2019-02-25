package com.textile.client.shop_car.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.game.base.image.ImageUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.shop_car.model.ConfirmOrderModel
import com.textile.client.shop_car.model.ShopCartModel
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.adapter_confirm_order_item.view.*
import kotlinx.android.synthetic.main.adapter_item_shop_car.view.*

/**
 * Created by admin on 2019/2/21.
 */
class ConfirmOrderAdapter(context: Context,helper:LayoutHelper):DelegateAdapter.Adapter<ConfirmOrderAdapter.ConfirmOrderHolder>() {

    private val mHelper = helper
    private val mContext = context
    var orderList:List<ConfirmOrderModel.ProductVOS> = ArrayList()
    var itemClickListener:RecyclerItemClickListener<ConfirmOrderModel.ProductVOS>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmOrderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_confirm_order_item, parent, false)
        return ConfirmOrderHolder(view)
    }

    override fun getItemCount() = orderList.size

    override fun onCreateLayoutHelper() = mHelper

    override fun onBindViewHolder(holder: ConfirmOrderHolder, position: Int) {
        val productVOS = orderList[position]
        ImageUtil.displayImage(mContext,holder.itemView.iv_confirmOrder_adapter_merchant_icon,productVOS.companyLogoUrl,R.drawable.default_header)
        holder.itemView.tv_confirmOrder_adapter_merchant_name.text = productVOS.companyName
        holder.itemView.tv_confirmOrder_adapter_fahuodi_name.text = productVOS.address
        holder.itemView.tv_confirmOrder_adapter_num.text = "${productVOS.amount}"
        holder.itemView.tv_confirmOrder_adapter_money.text = mContext.getString(R.string.order_price_text,productVOS.money)
        holder.itemView.tv_confirmOrder_adapter_wuliu_name.text = productVOS.expressName
        holder.itemView.tv_confirmOrder_adapter_product_name.text = productVOS.name
        holder.itemView.tv_confirmOrder_adapter_product_xinghao.text = productVOS.model
        holder.itemView.tv_confirmOrder_adapter_yunfei_name.text = productVOS.freight
        ImageUtil.displayImage(mContext,holder.itemView.iv_confirmOrder_adapter_product_icon,productVOS.imageUrl,R.drawable.default_header)

        holder.itemView.tv_confirmOrder_adapter_minus.setOnClickListener {
            if (productVOS.amount==1){
                it.context.toast(R.string.not_minus_shop_car)
            }else{
                productVOS.amount--
                productVOS.type=2
                itemClickListener?.onItemClick(productVOS,position)
                notifyItemChanged(position)
            }
        }

        holder.itemView.tv_confirmOrder_adapter_plus.setOnClickListener {
            productVOS.amount++
            productVOS.type=1
            itemClickListener?.onItemClick(productVOS,position)
            notifyItemChanged(position)
        }
    }

    inner class ConfirmOrderHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}