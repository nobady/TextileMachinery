package com.yang.mac.memodule.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yang.mac.memodule.R

/**
 * Created by bo on 2019/1/12.
 */
class SupplyAdapter : RecyclerView.Adapter<SupplyAdapter.SupplyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SupplyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_supply, parent, false)
        return SupplyHolder(view)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(p0: SupplyHolder, p1: Int) {

    }

    inner class SupplyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}