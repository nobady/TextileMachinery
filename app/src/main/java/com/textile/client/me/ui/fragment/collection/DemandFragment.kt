package com.textile.client.me.ui.fragment.collection

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.game.base.mvp.BaseFragment
import com.game.base.utils.dip2Px
import com.textile.client.R
import com.textile.client.me.contract.CollectDemandContract
import com.textile.client.me.model.CollectDemandModel
import com.textile.client.me.presenter.CollectDemandPresenterImpl
import com.textile.client.me.ui.adapter.DemandAdapter
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem
import kotlinx.android.synthetic.main.fragment_demand.*

/**
 * 机械需求
 */
class DemandFragment : BaseFragment(), CollectDemandContract.ICollectDemandView {
    private val collectDemandPresenter by lazy { CollectDemandPresenterImpl() }
    private lateinit var demandAdapter: DemandAdapter

    override fun getListSuccess(data: CollectDemandModel) {
        demandAdapter.setData(data.list)
    }

    override fun initView(view: View) {
        initRv()
    }

    override fun lazyLoadData() {
        collectDemandPresenter.attachView(this)
        collectDemandPresenter.getListDemandCollect()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_demand
    }

    private fun initRv() {
        mDemandRv.layoutManager = LinearLayoutManager(activity)
        mDemandRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(0, 30, 0, 0)
            }
        })
        mDemandRv.setSwipeMenuCreator { leftMenu, rightMenu, position ->
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            val deleteItem = SwipeMenuItem(this@DemandFragment.context)
            deleteItem
                .setBackgroundColorResource(R.color.slideDelColor)
                .setImage(R.drawable.delete)
                .setWidth(this@DemandFragment.context.dip2Px(57))
                .setHeight(height)
                .setText("删除")
                .setTextColorResource(android.R.color.white).textSize = 10
            rightMenu.addMenuItem(deleteItem)
        }
        demandAdapter = DemandAdapter()
        mDemandRv.adapter = demandAdapter
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DemandFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
