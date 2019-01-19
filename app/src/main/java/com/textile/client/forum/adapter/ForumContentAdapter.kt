package com.textile.client.forum.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.game.base.image.ImageUtil
import com.game.base.utils.DataTimeUtil
import com.textile.client.R
import com.textile.client.forum.model.ForumModel


class ForumContentAdapter(private val recyclerView: RecyclerView, private val helper: LayoutHelper) :
    DelegateAdapter.Adapter<ForumContentAdapter.ForumContentHolder>() {
    private var mContext: Context? = null
    private var data: List<ForumModel.X>? = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ForumContentHolder {
        mContext = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forum, parent, false)
        return ForumContentHolder(view)
    }

    fun setData(list: List<ForumModel.X>) {
        data = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (data?.isEmpty()!!) 0 else data!!.size
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
        return helper
    }

    override fun onBindViewHolder(holder: ForumContentHolder, position: Int) {

        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5)
        if (position == 0) {
            layoutParams.height = 30
        } else {
            layoutParams.height = 5
        }
        holder.mItemForumLine.layoutParams = layoutParams

        val bean = data?.get(position)
        bean?.userImage?.let {
            ImageUtil.displayCircleImage(
                mContext!!,
                holder.mItemForumAvatar,
                it,
                R.drawable.default_header
            )
        }
        holder.mItemForumUserName.text = bean?.userId.toString()
//        holder.mItemForumRank.text = bean.
//        holder.mItemForumCompany.text = bean.
        holder.mItemForumDate.text = DataTimeUtil.formatDateTime(bean?.createAt?.toLong()!!)
        holder.mItemForumContent.text = bean?.content

        holder.mItemForumColl.text = bean?.collectNum.toString()
        holder.mItemForumCom.text = bean?.commentNum.toString()

        holder.mItemForumRank.visibility = GONE
        holder.mItemForumJobRv.visibility = GONE

        holder.mItemForumColl.setOnClickListener {
            if (holder.mItemForumColl.isSelected) {
                holder.mItemForumColl.text = (bean?.collectNum).toString()
                holder.mItemForumColl.isSelected = false
            } else {
                holder.mItemForumColl.text = (bean?.collectNum + 1).toString()
                holder.mItemForumColl.isSelected = true
            }
        }
        holder.mItemForumCom.setOnClickListener {
            holder.mItemForumCom.text = (bean?.collectNum + 1).toString()
        }
    }

    inner class ForumContentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
}