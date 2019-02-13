package com.textile.client.mall.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.game.base.image.ImageUtil
import com.textile.client.R
import com.textile.client.login.model.UserPrefs
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.ui.ClassifyInfoActivity
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.adapter_item_category.view.*

/**
 * Created by lff on 2019/1/16.
 */
class ClassifyAdapter(context: Context,layoutHelper: LayoutHelper):DelegateAdapter.Adapter<ClassifyAdapter.ClassifyViewHolder>() {

    private val helper = layoutHelper
    private val mContext = context

     var categoryList:List<CategoryModel.ListData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): ClassifyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_category, parent, false)
        return ClassifyViewHolder(view)
    }

    override fun getItemCount() = categoryList.size

    override fun onCreateLayoutHelper() = helper

    override fun onBindViewHolder(holder: ClassifyViewHolder, position: Int) {
        if (UserPrefs.getInstance.getLanguage()==1) { //中文
            holder.itemView.tv_category_name.text = categoryList[position].name
        }else{
            holder.itemView.tv_category_name.text = categoryList[position].ename
        }
        ImageUtil.displayCircleImage(mContext,holder.itemView.iv_category_icon,categoryList[position].image)

        holder.itemView.setOnClickListener {
            gotoMallProduct(categoryList[position])
        }
    }

    private fun gotoMallProduct(listData: CategoryModel.ListData) {
        val intent = Intent()
        intent.putExtra("title",listData.name)
        intent.putExtra("id",listData.id)
        intent.setClass(mContext,ClassifyInfoActivity::class.java)
        mContext.startActivity(intent)
    }

    inner class ClassifyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}