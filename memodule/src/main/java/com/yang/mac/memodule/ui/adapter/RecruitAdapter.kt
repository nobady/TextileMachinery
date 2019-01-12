package com.yang.mac.memodule.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yang.mac.memodule.R

/**
 * Created by bo on 2019/1/12.
 */
class RecruitAdapter : RecyclerView.Adapter<RecruitAdapter.RecruitHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecruitHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recruit, parent, false)
        return RecruitHolder(view)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(p0: RecruitHolder, p1: Int) {

    }

    inner class RecruitHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}