package com.textile.client.forum.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.game.base.image.ImageUtil
import com.game.base.utils.DataTimeUtil
import com.textile.client.R
import com.textile.client.forum.ForumContentHolder
import com.textile.client.forum.model.TechModel
import com.textile.client.forum.ui.activity.DetailActivity

class TechAdapter(val data: List<TechModel.X>) : RecyclerView.Adapter<ForumContentHolder>() {
    private lateinit var mContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ForumContentHolder {
        mContext = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forum, parent, false)
        return ForumContentHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ForumContentHolder, position: Int) {
        val bean = data[position]
        bean?.run {
            ImageUtil.displayImage(mContext, holder.mItemForumAvatar, avatar, R.drawable.default_header)
            holder.mItemForumUserName.text = name
            holder.mItemForumCom.text = commentCount.toString()
            holder.mItemForumColl.text = (collectionCount).toString()
            holder.mItemForumContent.text = content
            holder.mItemForumDate.text = DataTimeUtil.formatDateTime(createAt.toLong())

            holder.mItemForumRank.visibility = View.GONE
            holder.mItemForumJobRv.visibility = View.GONE

            holder.mItemForumColl.setOnClickListener {
                if (holder.mItemForumColl.isSelected) {
                    holder.mItemForumColl.text = (collectionCount).toString()
                    holder.mItemForumColl.isSelected = false
                } else {
                    holder.mItemForumColl.text = (collectionCount + 1).toString()
                    holder.mItemForumColl.isSelected = true
                }
            }
            holder.mItemForumCom.setOnClickListener {
                holder.mItemForumCom.text = (collectionCount + 1).toString()
            }

            if (!bean.imageUrls.isEmpty()) {
                holder.mItemForumRv.adapter = ImageAdapter(bean.imageUrls)
            }

            holder.mItemForumContent.setOnClickListener {
                val intent = Intent(mContext, DetailActivity::class.java)
                intent.putExtra(DetailActivity.ITEM_ID_KEY, id.toString())
                mContext.startActivity(intent)
            }
        }
    }
}