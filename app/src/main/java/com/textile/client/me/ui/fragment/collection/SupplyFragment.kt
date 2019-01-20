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
import com.textile.client.me.ui.adapter.SupplyAdapter
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem
import kotlinx.android.synthetic.main.fragment_supply.*

/**
 * 机械供给
 */
class SupplyFragment : BaseFragment() {
    override fun initView(view: View) {
        initRv()
    }

    override fun lazyLoadData() {
        
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_supply
    }

    private fun initRv() {
        mSupplyRv.layoutManager = LinearLayoutManager(activity)
        mSupplyRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(0, 30, 0, 0)
            }
        })
        mSupplyRv.setSwipeMenuCreator { leftMenu, rightMenu, position ->
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            val deleteItem = SwipeMenuItem(this@SupplyFragment.context)
            deleteItem
                .setBackgroundColorResource(R.color.slideDelColor)
                .setImage(R.drawable.delete)
                .setWidth(this@SupplyFragment.context.dip2Px(57))
                .setHeight(height)
                .setText("删除")
                .setTextColorResource(android.R.color.white).textSize = 10
            rightMenu.addMenuItem(deleteItem)
        }
        mSupplyRv.adapter = SupplyAdapter()
    }

    companion object {
        /**
         * @return A new instance of fragment SupplyFragment.
         */
        @JvmStatic
        fun newInstance() =
            SupplyFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
