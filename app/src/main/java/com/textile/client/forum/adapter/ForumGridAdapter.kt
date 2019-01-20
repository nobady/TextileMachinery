package com.textile.client.forum.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.textile.client.R

/**
 * Created by bo on 2019/1/16.
 */
class ForumGridAdapter(private val helper: LayoutHelper, val listener: ForumGridClickListener) :
    DelegateAdapter.Adapter<ForumGridAdapter.ForumHolder>() {
    private var mContext: Context? = null
    private val iconArray = arrayOf(
        R.drawable.tech_exchange,
        R.drawable.mech_demand,
        R.drawable.mech_supply,
        R.drawable.want_job,
        R.drawable.recruit
    )

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ForumHolder {
        mContext = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_category, parent, false)
        return ForumHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateLayoutHelper(): LayoutHelper {

        return helper
    }

    override fun onBindViewHolder(holder: ForumHolder, position: Int) {
        val stringArray = mContext?.resources?.getStringArray(R.array.collectionTabs)
        holder.categoryName.text = stringArray?.get(position) ?: ""
        holder.categoryIcon.setImageResource(iconArray[position])
        holder.itemView.setOnClickListener {
            listener.onGridClick(position)
        }
    }


    inner class ForumHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryIcon = itemView.findViewById<ImageView>(R.id.iv_category_icon)
        val categoryName = itemView.findViewById<TextView>(R.id.tv_category_name)
    }

    interface ForumGridClickListener {
        fun onGridClick(position: Int)
    }
}