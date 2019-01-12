package com.yang.mac.memodule.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yang.mac.memodule.R

/**
 * Created by bo on 2019/1/12.
 */
class DemandAdapter : RecyclerView.Adapter<DemandAdapter.DemandHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DemandHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_demand, parent, false)
        return DemandHolder(view)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(p0: DemandHolder, p1: Int) {

    }

    inner class DemandHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}