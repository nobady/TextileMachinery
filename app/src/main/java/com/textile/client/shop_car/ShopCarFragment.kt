package com.textile.client.shop_car

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseFragment
import com.game.base.utils.setStatusBarColor
import com.game.base.utils.toActivityNotFinish
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
        setAllMoneyText()
        initEvent()
    }

    private fun initEvent() {
        cb_shopCar_all.setOnCheckedChangeListener { buttonView, isChecked ->
            shopCarAdapter.setSelectAll(isChecked)
            setAllMoneyText()
        }

        tv_shopCar_buy.setOnClickListener {
            //获取已选择的商品，跳转到确认订单页面
            val intent = Intent()
            intent.putExtra("selectList",shopCarAdapter.selectShopCartList as ArrayList)
            intent.setClass(context,ConfirmOrderActivity::class.java)
            toActivityNotFinish(intent)
        }
    }

    override fun onChecked(t: ShopCartModel.ListData, position: Int) {
        cb_shopCar_all.isChecked = false
        if (t.isChecked&&shopCarAdapter.shopCartList.size==shopCarAdapter.selectShopCartList.size){
            cb_shopCar_all.isChecked = true
        }
        setAllMoneyText()
    }

    private fun setAllMoneyText(){
        tv_shopCar_AllMoney.text = getString(R.string.all_price_text,calculateMoney())
    }

    override fun onItemClick(t: ShopCartModel.ListData, position: Int) {
        if (position==-1){
            //查看订单详情
            mPresenter.getProductInfoById(t.id)
        }else{
            //修改数量
            mPresenter.modifyProductNumber(t.id,t.type)
        }
    }

    override fun setModifyProductNumberSuccess() {
        setAllMoneyText()
    }

    private fun calculateMoney(): Double {
        var allMoney = 0.0
        shopCarAdapter.selectShopCartList.forEach {
            allMoney+=it.amount*it.money.toDouble()
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
        shopCarAdapter.itemCheckListener = this
        shopCarAdapter.itemClickListener = this

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