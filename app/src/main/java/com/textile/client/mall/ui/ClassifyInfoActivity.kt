package com.textile.client.mall.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.game.base.mvp.BaseActivity
import com.textile.client.R
import com.textile.client.mall.contract.ClassifyInfoContract
import com.textile.client.mall.contract.ClassifyInfoPresenterImpl
import com.textile.client.mall.model.BrandModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.model.HotModel
import com.textile.client.mall.ui.adapter.HotProductAdapter
import com.textile.client.utils.RecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_classify_info.*

class ClassifyInfoActivity : BaseActivity(), ClassifyInfoContract.IClassifyInfoView,
    RecyclerItemClickListener<BrandModel> {


    private lateinit var titleName: String
    private lateinit var classifyId: String
    private val mPresenter by lazy { ClassifyInfoPresenterImpl() }
    private lateinit var hotProductAdapter: HotProductAdapter
    private var priceList = ArrayList<BrandModel>()
    private var brandList: List<BrandModel> = ArrayList()
    private var mIsPrice = false//是否是选择价格

    private var popupWindow:BrandPopupWindow? = null
    private var brandId = -1
    private var priceAsc = true

    override fun startLoad() {
        mPresenter.getCategoryList(brandId, classifyId, priceAsc)
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

        initPriceList()

        initEvent()
    }

    private fun initEvent() {
        tv_classify_info_class.setOnClickListener {
            mIsPrice = false
            if (brandList.isNotEmpty()) {
                popupWindow = BrandPopupWindow(this, brandList, mIsPrice, this)
                popupWindow?.show(it)
            }
        }

        tv_classify_info_price.setOnClickListener {
            mIsPrice = true
            popupWindow = BrandPopupWindow(this, priceList, mIsPrice, this)
            popupWindow?.show(it)
        }
    }

    override fun onItemClick(t: BrandModel, position: Int) {
        popupWindow?.dismiss()
        if (mIsPrice){
            priceAsc = position==0
        }else{
            brandId = t.categoryId
        }
        mPresenter.getCategoryList(brandId,classifyId,priceAsc)
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

    override fun setBrandList(data: List<BrandModel>) {
        brandList = data
    }

    override fun layoutId() = R.layout.activity_classify_info

    private fun initPriceList() {
        val brandModel1 = BrandModel(-2, "", 1, 1, "", "", "", "", 1, "从价格高到低排序", false)
        val brandModel2 = BrandModel(-2, "", 1, 1, "", "", "", "", 1, "从价格低到高排序", false)
        priceList.add(brandModel1)
        priceList.add(brandModel2)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
