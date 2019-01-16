package com.textile.client.forum.ui

import android.os.Bundle
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseFragment
import com.game.base.utils.setStatusBarColor
import com.textile.client.R
import com.textile.client.forum.ForumGridAdapter
import com.textile.client.forum.contract.ForumContract
import com.textile.client.forum.presenter.ForumPresenterImpl
import com.textile.client.mall.contract.MallContract
import com.textile.client.mall.contract.MallPresenterImpl
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.ui.adapter.BannerAdapter
import kotlinx.android.synthetic.main.fragment_forum.*


/**
 * 论坛
 */
class ForumFragment : BaseFragment(), ForumContract.IForumView, MallContract.IMallView {
    private lateinit var bannerAdapter: BannerAdapter

    override fun setBannerData(type: Int, bannerList: List<BannerModel.ListData>) {
        if (type == MallContract.BANNER_LUNTAN) {
            bannerAdapter?.imageUrls = bannerList
            bannerAdapter?.notifyDataSetChanged()
        }
    }

    override fun setCategoryData(mCategoryList: List<CategoryModel.ListData>) {

    }

    private val mForumPresenter by lazy { ForumPresenterImpl() }
    private val mMallPresenter by lazy { MallPresenterImpl() }
    override fun initView(view: View) {
        setStatusBarColor(android.R.color.transparent)
        mForumPresenter.attachView(this)
        mMallPresenter.attachView(this)
        val virtualLayoutManager = VirtualLayoutManager(context)
        val delegateAdapter = DelegateAdapter(virtualLayoutManager)
        mForumRv.setHasFixedSize(true)
        mForumRv.layoutManager = virtualLayoutManager
        mForumRv.adapter = delegateAdapter

        val bannerLayoutHelper = LinearLayoutHelper()
        bannerAdapter = BannerAdapter(bannerLayoutHelper)
        delegateAdapter.addAdapter(bannerAdapter)

        val gridLayoutHelper = GridLayoutHelper(5)
        val forumGridAdapter = ForumGridAdapter(gridLayoutHelper)
        delegateAdapter.addAdapter(forumGridAdapter)
    }

    override fun lazyLoadData() {
        mMallPresenter.getBannerList(MallContract.BANNER_LUNTAN)
        mForumPresenter.getForumList()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_forum
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ForumFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
