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
import com.textile.client.utils.RecycerItemCheckListener
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_shop_car.*
import kotlinx.android.synthetic.main.layout_order_buy.*

/**
 * Created by lff on 2019/1/17.
 */
class ShopCarFragment:BaseFragment(),ShopCartContract.IShopCartView,RecycerItemCheckListener<ShopCartModel.ListData>
    ,RecyclerItemClickListener<ShopCartModel.ListData> {


    private val mPresenter by lazy { ShopCartPresenterImpl() }

    private lateinit var shopCarAdapter:ShopCarAdapter
    override fun initView(view: View) {
        initTitle()
        mPresenter.attachView(this)
        initRecyclerView()
        initEvent()
    }

    private fun initEvent() {
        cb_shopCar_all.setOnCheckedChangeListener { buttonView, isChecked ->
            shopCarAdapter.setSelectAll(isChecked)
            tv_shopCar_AllMoney.text = "￥${calculateMoney()}元"
        }

        tv_shopCar_buy.setOnClickListener {
            //获取已选择的商品，跳转到确认订单页面
        }
    }

    override fun onChecked(t: ShopCartModel.ListData, position: Int) {
        cb_shopCar_all.isChecked = false
        if (t.isChecked&&shopCarAdapter.shopCartList.size==shopCarAdapter.selectShopCartList.size){
            cb_shopCar_all.isChecked = true
        }
        tv_shopCar_AllMoney.text = "￥${calculateMoney()}元"
    }

    override fun onItemClick(t: ShopCartModel.ListData, position: Int) {
        //修改数量
        mPresenter.modifyProductNumber(t.id,t.type)
    }

    override fun setModifyProductNumberSuccess() {
        tv_shopCar_AllMoney.text = "￥${calculateMoney()}元"
    }

    private fun calculateMoney(): Int {
        var allMoney = 0
        shopCarAdapter.selectShopCartList.forEach {
            allMoney+=it.amount*it.money.toInt()
        }
        return allMoney
    }

    private fun initRecyclerView() {
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