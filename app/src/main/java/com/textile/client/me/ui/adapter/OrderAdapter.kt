package com.textile.client.me.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.textile.client.R

/**
 * Created by bo on 2019/1/13.
 */
class OrderAdapter: RecyclerView.Adapter<OrderAdapter.OrderHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): OrderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_job_want, parent, false)
        return OrderHolder(view)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(p0: OrderHolder, p1: Int) {

    }

    inner class OrderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}