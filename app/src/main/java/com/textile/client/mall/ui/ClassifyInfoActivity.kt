package com.textile.client.mall.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.game.base.mvp.BaseActivity
import com.textile.client.R
import com.textile.client.mall.contract.ClassifyInfoContract
import com.textile.client.mall.contract.ClassifyInfoPresenterImpl
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.model.HotModel
import com.textile.client.mall.ui.adapter.HotProductAdapter
import kotlinx.android.synthetic.main.activity_classify_info.*

class ClassifyInfoActivity : BaseActivity(),ClassifyInfoContract.IClassifyInfoView {

    private lateinit var titleName:String
    private lateinit var classifyId :String
    private val mPresenter by lazy { ClassifyInfoPresenterImpl() }
    private lateinit var hotProductAdapter:HotProductAdapter

    override fun startLoad() {
        mPresenter.getCategoryList(-1,classifyId,true)
        mPresenter.getBrandData(classifyId)
    }

    override fun initView() {
        initTitle()
        val layoutManager = VirtualLayoutManager(this)
        layoutManager.orientation = VirtualLayoutManager.VERTICAL
        val delegateAdapter = DelegateAdapter(layoutManager)
        classifyRecyclerView.setHasFixedSize(true)
        classifyRecyclerView.adapter = delegateAdapter
        classifyRecyclerView.layoutManager = layoutManager

        val hotLayoutHelper = GridLayoutHelper(2)
        hotLayoutHelper.setAutoExpand(false)
        hotProductAdapter = HotProductAdapter(hotLayoutHelper, this)
        delegateAdapter.addAdapter(hotProductAdapter)
    }

    private fun initTitle() {
        titleName = intent.getStringExtra("title")
        classifyId = intent.getStringExtra("id")
        classifyHeadView.setTitle(titleName)
        classifyHeadView.showBack()
    }

    override fun initData() {
        mPresenter.attachView(this)
    }

    override fun setCategoryList(dataList: List<HotModel.ListData>) {
        hotProductAdapter.hotList = dataList
        hotProductAdapter.notifyDataSetChanged()
    }

    override fun layoutId() = R.layout.activity_classify_info

    fun initPopup(){

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
