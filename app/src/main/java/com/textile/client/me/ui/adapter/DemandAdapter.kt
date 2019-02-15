package com.textile.client.me.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.textile.client.R
import com.textile.client.me.model.X

/**
 * Created by bo on 2019/1/12.
 */
class DemandAdapter : RecyclerView.Adapter<DemandAdapter.DemandHolder>() {
    private var data: List<X>? = null
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DemandHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_demand, parent, false)
        return DemandHolder(view)
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    override fun onBindViewHolder(holder: DemandHolder, position: Int) {
        val bean = data?.get(position)
        bean?.run {
            holder.mDemandTitle.text = title
            holder.mDemandDate.text = createAt
            holder.mDemandPrice.text = expectedSalary
            holder.mDemandContent.text = content
        }
    }

    fun setData(list: List<X>) {
        data = list
        notifyDataSetChanged()
    }

    inner class DemandHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mDemandTitle = itemView.findViewById<TextView>(R.id.mDemandTitle)
        val mDemandContent = itemView.findViewById<TextView>(R.id.demand_content)
        val mDemandPrice = itemView.findViewById<TextView>(R.id.mDemandPrice)
        val mDemandDate = itemView.findViewById<TextView>(R.id.mDemandDate)
        val mMeUserRank = itemView.findViewById<TextView>(R.id.mMeUserRank)
    }
}