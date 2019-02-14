package com.textile.client.mall.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseFragment
import com.game.base.utils.setStatusBarColor

import com.textile.client.R
import com.textile.client.mall.contract.MallContract
import com.textile.client.mall.contract.MallPresenterImpl
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.model.HotModel
import com.textile.client.mall.ui.adapter.*
import kotlinx.android.synthetic.main.fragment_mall.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MallFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MallFragment : BaseFragment(), MallContract.IMallView {


    private val mPresenter by lazy { MallPresenterImpl() }

    private lateinit var delegateAdapter: DelegateAdapter

    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var bdAdapter: BDAdapter//广告
    private lateinit var classifyAdapter: ClassifyAdapter
    private lateinit var hotProductAdapter: HotProductAdapter

    override fun initView(view: View) {

        setStatusBarColor(android.R.color.transparent)
        mPresenter.attachView(this)

        val layoutManager = VirtualLayoutManager(context)
        layoutManager.orientation = VirtualLayoutManager.VERTICAL
        delegateAdapter = DelegateAdapter(layoutManager)
        mall_recycler.setHasFixedSize(true)
        mall_recycler.adapter = delegateAdapter
        mall_recycler.layoutManager = layoutManager

        val bannerLayoutHelper = LinearLayoutHelper()
        bannerAdapter = BannerAdapter(bannerLayoutHelper)
        delegateAdapter.addAdapter(bannerAdapter)

        val classifyLayoutHelper = GridLayoutHelper(4)
        classifyAdapter = ClassifyAdapter(context, classifyLayoutHelper)
        delegateAdapter.addAdapter(classifyAdapter)

        val bdLayoutHelper = LinearLayoutHelper()
        bdAdapter = BDAdapter(bdLayoutHelper)
        delegateAdapter.addAdapter(bdAdapter)

        val textLayoutHelper = LinearLayoutHelper()
        val textAdapter = TextAdapter(textLayoutHelper)
        delegateAdapter.addAdapter(textAdapter)

        val hotLayoutHelper = GridLayoutHelper(2)
        hotLayoutHelper.setAutoExpand(false)
        hotProductAdapter = HotProductAdapter(hotLayoutHelper, context)
        delegateAdapter.addAdapter(hotProductAdapter)
    }

    override fun lazyLoadData() {
        mPresenter.getBannerList(MallContract.BANNER_MALL)
        mPresenter.getCategoryList()
        mPresenter.getBannerList(MallContract.BANNER_MALL_BD)
        mPresenter.getHotProductList()
    }

    override fun setBannerData(type: Int, bannerList: List<BannerModel.ListData>) {
        if (type == MallContract.BANNER_MALL) {
            bannerAdapter.imageUrls = bannerList
            bannerAdapter.notifyDataSetChanged()
        } else if (type == MallContract.BANNER_MALL_BD) {
            bdAdapter.imageUrls = bannerList
            bdAdapter.notifyDataSetChanged()
        }
    }

    override fun setCategoryData(mCategoryList: List<CategoryModel.ListData>) {
        classifyAdapter.categoryList = mCategoryList
        classifyAdapter.notifyDataSetChanged()
    }

    override fun setHotList(hotList: List<HotModel.ListData>) {
        hotProductAdapter.hotList = hotList
        hotProductAdapter.notifyDataSetChanged()
    }

    override fun getLayoutId() = R.layout.fragment_mall

    companion object {
        /**
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         */
        @JvmStatic
        fun newInstance() =
            MallFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
