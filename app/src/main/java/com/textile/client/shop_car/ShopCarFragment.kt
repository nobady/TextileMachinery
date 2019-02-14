package com.textile.client.shop_car

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseFragment
import com.game.base.utils.setStatusBarColor
import com.textile.client.R
import com.textile.client.shop_car.adapter.ShopCarAdapter
import com.textile.client.shop_car.contract.ShopCartContract
import com.textile.client.shop_car.contract.ShopCartPresenterImpl
import com.textile.client.shop_car.model.ShopCartModel
import kotlinx.android.synthetic.main.fragment_shop_car.*

/**
 * Created by lff on 2019/1/17.
 */
class ShopCarFragment:BaseFragment(),ShopCartContract.IShopCartView {

    private val mPresenter by lazy { ShopCartPresenterImpl() }

    private lateinit var shopCarAdapter:ShopCarAdapter
    override fun initView(view: View) {
        initTitle()
        mPresenter.attachView(this)
        shopCarRecyclerView.setHasFixedSize(true)

        val manager = VirtualLayoutManager(context)
        manager.orientation = VirtualLayoutManager.VERTICAL
        shopCarRecyclerView.layoutManager = manager
        val adapter = DelegateAdapter(manager)

        shopCarAdapter = ShopCarAdapter(LinearLayoutHelper())
        adapter.addAdapter(shopCarAdapter)

        shopCarRecyclerView.adapter = adapter

    }

    private fun initTitle() {
        setStatusBarColor(android.R.color.transparent)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = ""
    }

    override fun setShopCartData(dataList: List<ShopCartModel.ListData>) {
        shopCarAdapter.shopCartList = dataList
        shopCarAdapter.notifyDataSetChanged()
    }

    override fun lazyLoadData() {
        mPresenter.getShopCartList()
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

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}