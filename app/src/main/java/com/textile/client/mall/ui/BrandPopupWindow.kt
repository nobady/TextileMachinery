package com.textile.client.mall.ui

import android.app.Activity
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.utils.dip2Px
import com.textile.client.R
import com.textile.client.forum.adapter.ForumGridAdapter
import com.textile.client.mall.model.BrandModel
import com.textile.client.mall.ui.adapter.TextChooseAdapter
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.layout_bottom_popup_home.view.*
import kotlinx.android.synthetic.main.layout_recyclerview.view.*

/**
 * Created by lff on 2019/2/15.
 */
class BrandPopupWindow(context: Activity,brandList: List<BrandModel>,isPrice:Boolean,itemClickListener: RecyclerItemClickListener<BrandModel>):PopupWindow(context) {

    private val mContext = context
    private val mItemClickListener = itemClickListener
    private val mBrandList = brandList
    private var mIsPrice = isPrice

    init {
        init()
    }

    private fun init(){
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_recyclerview, null)
        initRecyclerView(view)

        width = WindowManager.LayoutParams.MATCH_PARENT
        height = WindowManager.LayoutParams.MATCH_PARENT
        val screenHeight = mContext.windowManager.defaultDisplay.height
        if (!mIsPrice&&(mBrandList.size*mContext.dip2Px(40)>screenHeight/2)){
            val layoutParams = view.commonRecyclerView.layoutParams
            layoutParams.height = screenHeight/2
            view.commonRecyclerView.layoutParams = layoutParams
        }

        isFocusable = true
        val dw = ColorDrawable(0x00000000)
        setBackgroundDrawable(dw)

        view.bg_view.setOnClickListener { dismiss() }
        contentView = view

    }

    private fun initRecyclerView(view: View) {
        val virtualLayoutManager = VirtualLayoutManager(mContext)
        val delegateAdapter = DelegateAdapter(virtualLayoutManager)
        view.commonRecyclerView.setHasFixedSize(true)
        view.commonRecyclerView.layoutManager = virtualLayoutManager
        view.commonRecyclerView.adapter = delegateAdapter
        val gridLayoutHelper = LinearLayoutHelper(1)
        val forumGridAdapter = TextChooseAdapter(gridLayoutHelper)
        forumGridAdapter.itemClickListener = mItemClickListener
        forumGridAdapter.brandList = mBrandList
        delegateAdapter.addAdapter(forumGridAdapter)

    }

    fun show(view: View){
        val location = IntArray(2)
        view.getLocationOnScreen(location)
        val screenHeight = mContext.windowManager.defaultDisplay.height
        val height = screenHeight - view.height - location[1]
        setHeight(height)
        showAsDropDown(view)
    }


}