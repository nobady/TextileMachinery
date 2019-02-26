package com.textile.client.shop_car.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseActivity
import com.tencent.bugly.proguard.t
import com.textile.client.R
import com.textile.client.shop_car.adapter.MyAddressAdapter
import com.textile.client.shop_car.contract.MyAddressContract
import com.textile.client.shop_car.model.MyAddressModel
import com.textile.client.shop_car.presenter.MyAddressPresenterImpl
import kotlinx.android.synthetic.main.activity_my_address.*
import kotlinx.android.synthetic.main.layout_address.*

class MyAddressActivity : BaseActivity(),MyAddressContract.IMyAddressView {


    private val mPresenter by lazy { MyAddressPresenterImpl() }
    private lateinit var addressAdapter:MyAddressAdapter

    override fun showUserAddressList(dataList: List<MyAddressModel>) {
        addressAdapter.dataList = dataList
        addressAdapter.notifyDataSetChanged()
    }

    override fun showEmptyLayout() {
        layout_my_address.visibility = View.GONE
        view.visibility = View.GONE
        view1.visibility = View.GONE
    }

    override fun showDefaultAddress(myAddressModel: MyAddressModel) {
        layout_my_address.visibility = View.VISIBLE
        view.visibility = View.VISIBLE
        view1.visibility = View.VISIBLE

        tv_order_receiver_people.text = getString(R.string.address_receiver_people,myAddressModel.receiver)
        tv_order_receiver_phone.text = myAddressModel.phone
        iv_order_location.setImageResource(R.mipmap.default_address_icon)
        val foregroundColorSpan = ForegroundColorSpan(resources.getColor(R.color.red))
        val backgroundColorSpan = BackgroundColorSpan(resources.getColor(R.color.grey))
        val spannableStringBuilder = SpannableStringBuilder()
        spannableStringBuilder.append(getString(R.string.default_address_text),foregroundColorSpan,Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(backgroundColorSpan,0,spannableStringBuilder.length,Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.append(getString(R.string.shouhuo_address,myAddressModel.address))
        tv_order_receiver_address.text = spannableStringBuilder

    }

    override fun startLoad() {
        mPresenter.getUserAddressList()
    }

    override fun initView() {
        mPresenter.attachView(this)

        myAddressHeadView.showBack()
        myAddressHeadView.setTitle(getString(R.string.title_my_address))
        myAddressHeadView.showRightTv(getString(R.string.title_address_add_new), View.OnClickListener {
            //跳转都添加地址页面
        },R.color.title_right_bg)

        myAddressRecyclerView.setHasFixedSize(true)

        val virtualLayoutManager = VirtualLayoutManager(this,VirtualLayoutManager.VERTICAL)
        myAddressRecyclerView.layoutManager = virtualLayoutManager
        val delegateAdapter = DelegateAdapter(virtualLayoutManager)

         addressAdapter = MyAddressAdapter(this,LinearLayoutHelper())
        delegateAdapter.addAdapter(addressAdapter)

        myAddressRecyclerView.adapter = delegateAdapter

    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_my_address

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}
