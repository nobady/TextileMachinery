package com.yang.mac.memodule.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yang.mac.memodule.R

/**
 * Created by bo on 2019/1/12.
 */
class TechExcAdaper : RecyclerView.Adapter<TechExcAdaper.TechExcHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TechExcHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tech_exc, parent, false)
        return TechExcHolder(view)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(holder: TechExcHolder, position: Int) {

    }

    inner class TechExcHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}