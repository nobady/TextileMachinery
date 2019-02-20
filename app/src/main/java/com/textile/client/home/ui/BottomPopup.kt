package com.textile.client.home.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.game.base.utils.toActivityNotFinish
import com.textile.client.R
import com.textile.client.forum.adapter.ForumGridAdapter
import kotlinx.android.synthetic.main.fragment_forum.*
import kotlinx.android.synthetic.main.layout_bottom_popup_home.view.*

/**
 * Created by lff on 2019/2/14.
 */
class BottomPopup(context: Activity):PopupWindow(context),ForumGridAdapter.ForumGridClickListener {

    private val mContext = context
    private var measuredWidth:Int = 0
    private var measuredHeight:Int = 0

    init {
        init()
    }

    private fun init(){

        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_bottom_popup_home, null)
        initRecyclerView(view)
        view.iv_popup_close.setOnClickListener { dismiss() }

        width = WindowManager.LayoutParams.MATCH_PARENT
        height = WindowManager.LayoutParams.WRAP_CONTENT
        isFocusable = true
        val dw = ColorDrawable(0x00000000)
        setBackgroundDrawable(dw)
        backgroundAlpha(0.5f)

        setOnDismissListener { backgroundAlpha(1f) }

        view.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
         measuredWidth = view.measuredWidth
         measuredHeight = view.measuredHeight

        contentView = view
    }

    private fun initRecyclerView(view: View) {
        val virtualLayoutManager = VirtualLayoutManager(mContext)
        val delegateAdapter = DelegateAdapter(virtualLayoutManager)
        view.publishRecyclerView.setHasFixedSize(true)
        view.publishRecyclerView.layoutManager = virtualLayoutManager
        view.publishRecyclerView.adapter = delegateAdapter
        val gridLayoutHelper = GridLayoutHelper(5)
        val forumGridAdapter = ForumGridAdapter(gridLayoutHelper, this)
        delegateAdapter.addAdapter(forumGridAdapter)
    }

    fun showUpView(view: View){
        val location = IntArray(2)
        view.getLocationOnScreen(location)
        showAtLocation(view,Gravity.NO_GRAVITY,(location[0]+view.width/2)-measuredWidth/2,location[1]-measuredHeight)
    }

    private fun backgroundAlpha(bgAlpha:Float){
        val attributes = mContext.window.attributes
        attributes.alpha = bgAlpha
        mContext.window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        mContext.window.attributes = attributes
    }

    override fun onGridClick(position: Int) {
        when (position) {
            0 -> {
            }
            1 -> {
            }
            2 -> {
//                toActivityNotFinish(Mech::class.java)
            }
            3 -> {
            }
            4 -> {
            }
            else -> {
            }
        }
    }

//    private fun toActivityNotFinish(clazz: Class<MechSupplyActivity>) {
//        val intent = Intent(mContext, clazz)
//        mContext.startActivity(intent)
//    }


}