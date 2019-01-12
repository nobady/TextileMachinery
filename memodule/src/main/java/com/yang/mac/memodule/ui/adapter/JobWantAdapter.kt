package com.yang.mac.memodule.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yang.mac.memodule.R

/**
 * Created by bo on 2019/1/12.
 */
class JobWantAdapter : RecyclerView.Adapter<JobWantAdapter.JobWantHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): JobWantAdapter.JobWantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_job_want, parent, false)
        return JobWantHolder(view)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(p0: JobWantHolder, p1: Int) {

    }

    inner class JobWantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}