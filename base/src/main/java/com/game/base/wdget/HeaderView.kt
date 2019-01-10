package com.game.base.wdget

import android.app.Activity
import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.game.base.R
import kotlinx.android.synthetic.main.head_view.view.*

/**
 * Created by bo on 2019/1/6.
 * 1.默认除了中间的标题其他的全是隐藏的
 * 2.需要显示什么调用相应的方法就行
 * 3.返回按钮显示的时候已经设置点击事件
 * 4.可以设置背景颜色和文字颜色
 */
class HeaderView(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.head_view, this, true)
    }

    fun setBackground(@ColorRes colorRes: Int) {
        mHeadRootView.setBackgroundColor(context.resources.getColor(colorRes))
    }

    fun setTitle(title: String = "") {
        mHeadCenterTv.text = title
    }

    fun setTitle(txtId: Int) {
        mHeadCenterTv.setText(txtId)
    }

    fun setTitleTextColor(@ColorRes colorRes: Int) {
        mHeadCenterTv.setTextColor(context.resources.getColor(colorRes))
    }

    fun showBack() {
        mHeadBackIv.visibility = View.VISIBLE
        mHeadBackIv.setOnClickListener {
            if (it.context is Activity) {
                (it.context as Activity).finish()
            }
        }
    }

    fun showBack(@DrawableRes drawId: Int) {
        mHeadBackIv.setImageResource(drawId)
        showBack()
    }

    fun showOneRightIv(@DrawableRes drawId: Int, listener: RightIv2ClickListener) {
        mHeadRightIv2.visibility = View.VISIBLE
        mHeadRightIv2.setImageResource(drawId)
        mHeadRightIv2.setOnClickListener { listener?.onRightIv2Click(it as ImageView) }
    }

    fun showTwoRightIv(
        @DrawableRes drawId1: Int, @DrawableRes drawId2: Int, listener1: RightIv1ClickListener,
        listener2: RightIv2ClickListener
    ) {
        mHeadRightIv1.visibility = View.VISIBLE
        mHeadRightIv2.visibility = View.VISIBLE
        mHeadRightIv1.setImageResource(drawId1)
        mHeadRightIv2.setImageResource(drawId2)
        mHeadRightIv1.setOnClickListener { listener1.onRightIv1Click(it as ImageView) }
        mHeadRightIv2.setOnClickListener { listener2.onRightIv2Click(it as ImageView) }
    }

    fun showRightTv(
        msg: String = "",
        clickListener: View.OnClickListener, @ColorRes colorRes: Int = android.R.color.white
    ) {
        mHeadRightTv.visibility = View.VISIBLE
        mHeadRightTv.text = msg
        mHeadRightTv.setOnClickListener(clickListener)
        mHeadRightTv.setTextColor(context.resources.getColor(colorRes))
    }

    interface RightIv1ClickListener {
        fun onRightIv1Click(rightIv1: ImageView)
    }

    interface RightIv2ClickListener {
        fun onRightIv2Click(rightIv2: ImageView)
    }
}