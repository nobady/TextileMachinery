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
import com.textile.client.me.ui.adapter.JobWantAdapter
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem
import kotlinx.android.synthetic.main.fragment_job_want.*

/**
 *求职
 */
class JobWantFragment : BaseFragment() {
    override fun initView(view: View) {
        initRv()
    }

    override fun lazyLoadData() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_job_want
    }

    private fun initRv() {
        mJobRv.layoutManager = LinearLayoutManager(activity)
        mJobRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(0, 30, 0, 0)
            }
        })
        mJobRv.setSwipeMenuCreator { leftMenu, rightMenu, position ->
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            val deleteItem = SwipeMenuItem(this@JobWantFragment.context)
            deleteItem
                .setBackgroundColorResource(R.color.slideDelColor)
                .setImage(R.drawable.delete)
                .setWidth(this@JobWantFragment.context.dip2Px(57))
                .setHeight(height)
                .setText("删除")
                .setTextColorResource(android.R.color.white).textSize = 10
            rightMenu.addMenuItem(deleteItem)
        }
        mJobRv.adapter = JobWantAdapter()
    }

    companion object {
        /**
         * @return A new instance of fragment JobWantFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            JobWantFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
