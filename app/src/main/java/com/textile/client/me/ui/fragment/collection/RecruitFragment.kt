package com.textile.client.me.ui.fragment.collection

import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.game.base.mvp.BaseFragment
import com.game.base.utils.dip2Px
import com.textile.client.R
import com.textile.client.me.ui.adapter.RecruitAdapter
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem
import kotlinx.android.synthetic.main.fragment_recruit.*

/**
 * 招聘
 */
class RecruitFragment : BaseFragment() {
    override fun initView(view: View) {
        initRv()
    }

    override fun lazyLoadData() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_recruit
    }

    private fun initRv() {
        mRecruitRv.layoutManager = LinearLayoutManager(activity)
        mRecruitRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(0, 30, 0, 0)
            }
        })
        mRecruitRv.setSwipeMenuCreator { leftMenu, rightMenu, position ->
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            val deleteItem = SwipeMenuItem(this@RecruitFragment.context)
            deleteItem
                .setBackgroundColorResource(R.color.slideDelColor)
                .setImage(R.drawable.delete)
                .setWidth(this@RecruitFragment.context.dip2Px(57))
                .setHeight(height)
                .setText("删除")
                .setTextColorResource(android.R.color.white).textSize = 10
            rightMenu.addMenuItem(deleteItem)
        }
        mRecruitRv.adapter = RecruitAdapter()
    }

    companion object {
        /**
         * @return A new instance of fragment RecruitFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RecruitFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
