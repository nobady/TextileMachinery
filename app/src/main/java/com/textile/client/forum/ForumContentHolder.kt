package com.textile.client.forum

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.textile.client.R

class ForumContentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mItemForumAvatar = itemView.findViewById<ImageView>(R.id.mItemForumAvatar)
        val mItemForumUserName = itemView.findViewById<TextView>(R.id.mItemForumUserName)
        val mItemForumRank = itemView.findViewById<TextView>(R.id.mItemForumRank)
        val mItemForumDate = itemView.findViewById<TextView>(R.id.mItemForumDate)
        val mItemForumCompany = itemView.findViewById<TextView>(R.id.mItemForumCompany)
        val mItemForumContent = itemView.findViewById<TextView>(R.id.mItemForumContent)
        val mItemForumRv = itemView.findViewById<RecyclerView>(R.id.mItemForumRv)
        val mItemForumComRv = itemView.findViewById<RelativeLayout>(R.id.mItemForumComRv)
        val mItemForumColl = itemView.findViewById<TextView>(R.id.mItemForumColl)
        val mItemForumCom = itemView.findViewById<TextView>(R.id.mItemForumCom)
        val mItemForumShare = itemView.findViewById<TextView>(R.id.mItemForumShare)
        val mItemForumJobRv = itemView.findViewById<RelativeLayout>(R.id.mItemForumJobRv)
        val mItemPrice = itemView.findViewById<TextView>(R.id.mItemPrice)
        val mItemForumContact = itemView.findViewById<TextView>(R.id.mItemForumContact)
        val mItemForumLine = itemView.findViewById<View>(R.id.mItemForumLine)
    }