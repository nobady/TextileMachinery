package com.textile.client.shop_car

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseFragment
import com.game.base.utils.setStatusBarColor
import com.textile.client.R
import com.textile.client.mall.ui.MallFragment
import com.textile.client.me.ui.adapter.OrderAdapter
import com.textile.client.shop_car.adapter.ShopCarAdapter
import kotlinx.android.synthetic.main.fragment_shop_car.*

/**
 * Created by lff on 2019/1/17.
 */
class ShopCarFragment:BaseFragment() {

    override fun initView(view: View) {
        setStatusBarColor(android.R.color.transparent)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = ""
        shopCarRecyclerView.setHasFixedSize(true)

        val manager = VirtualLayoutManager(context)
        manager.orientation = VirtualLayoutManager.VERTICAL
        shopCarRecyclerView.layoutManager = manager
        val adapter = DelegateAdapter(manager)
        adapter.addAdapter(ShopCarAdapter(LinearLayoutHelper()))

        shopCarRecyclerView.adapter = adapter

    }

    override fun lazyLoadData() {
    }

    override fun getLayoutId() = R.layout.fragment_shop_car

    companion object {
        /**
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         */
        @JvmStatic
        fun newInstance() =
            ShopCarFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}