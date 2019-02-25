package com.textile.client.shop_car

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseActivity
import com.tencent.bugly.proguard.t
import com.textile.client.R
import com.textile.client.shop_car.adapter.ConfirmOrderAdapter
import com.textile.client.shop_car.adapter.ShopCarAdapter
import com.textile.client.shop_car.contract.ConfirmOrderPresenterImpl
import com.textile.client.shop_car.contract.ConfrimOrderContract
import com.textile.client.shop_car.model.ConfirmOrderModel
import com.textile.client.shop_car.model.ShopCartModel
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_confirm_order.*
import kotlinx.android.synthetic.main.layout_order_buy.*

class ConfirmOrderActivity : BaseActivity(),ConfrimOrderContract.IConfirmOrderView,
    RecyclerItemClickListener<ConfirmOrderModel.ProductVOS> {



    private lateinit var selectList: ArrayList<ShopCartModel.ListData>
    private val mPresenter by lazy { ConfirmOrderPresenterImpl() }
    private lateinit var orderAdapter: ConfirmOrderAdapter

    override fun startLoad() {
        mPresenter.getShoppingCartList(selectList)
    }

    override fun initView() {
        mPresenter.attachView(this)

        confirmOrderHeadView.setTitle(R.string.confirm_order_title)
        confirmOrderHeadView.showBack()

        initRecyclerView()

        cb_shopCar_all.visibility = View.GONE
        tv_choose_all.visibility = View.GONE

    }

    private fun initRecyclerView() {
        orderRecycler.setHasFixedSize(true)

        val manager = VirtualLayoutManager(this)
        manager.orientation = VirtualLayoutManager.VERTICAL
        orderRecycler.layoutManager = manager
        val delegateAdapter = DelegateAdapter(manager)

        orderAdapter = ConfirmOrderAdapter(this, LinearLayoutHelper())
        delegateAdapter.addAdapter(orderAdapter)
        orderAdapter.itemClickListener = this

        orderRecycler.adapter = delegateAdapter
    }

    override fun initData() {
        selectList = intent.getSerializableExtra("selectList") as ArrayList<ShopCartModel.ListData>
    }

    override fun showUserAddress(userAddress: ConfirmOrderModel.UserAddress) {
        tv_order_receiver_people.text = userAddress.receiver
        tv_order_receiver_address.text = userAddress.address
        tv_order_receiver_phone.text = userAddress.phone

    }

    override fun showProductList(productVOS: List<ConfirmOrderModel.ProductVOS>) {
        orderAdapter.orderList = productVOS
        orderAdapter.notifyDataSetChanged()
    }

    override fun setModifyProductNumberSuccess() {

    }

    override fun showAllMoney(allMoney: Int) {
        tv_shopCar_AllMoney.text = getString(R.string.all_price_text,allMoney)
    }

    override fun onItemClick(t: ConfirmOrderModel.ProductVOS, position: Int) {
        //修改数量
        mPresenter.modifyProductNumber(t.id, t.type)
    }

    override fun layoutId() = R.layout.activity_confirm_order

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
