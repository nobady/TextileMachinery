package com.textile.client.me.ui.fragment.collection

import android.graphics.Rect
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.game.base.mvp.BaseFragment
import com.game.base.utils.dip2Px
import com.textile.client.R
import com.textile.client.me.ui.adapter.TechExcAdaper
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem
import kotlinx.android.synthetic.main.fragment_tech_exc.*
/**
 *技术交流
 */
class TechExcFragment : BaseFragment() {
    override fun initView(view: View) {
        initRv()
    }

    private fun initRv() {
        mTechExcRv.layoutManager = LinearLayoutManager(activity)
        mTechExcRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(0, 30, 0, 0)
            }
        })
        mTechExcRv.setSwipeMenuCreator { leftMenu, rightMenu, position ->
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            val deleteItem = SwipeMenuItem(this@TechExcFragment.context)
            deleteItem
                .setBackgroundColorResource(R.color.slideDelColor)
                .setImage(R.drawable.delete)
                .setWidth(this@TechExcFragment.context.dip2Px(57))
                .setHeight(height)
                .setText("删除")
                .setTextColorResource(android.R.color.white).textSize = 10
            rightMenu.addMenuItem(deleteItem)
        }
        mTechExcRv.adapter = TechExcAdaper()
    }

    override fun lazyLoadData() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_tech_exc
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TechExcFragment().apply {

            }
    }
}
