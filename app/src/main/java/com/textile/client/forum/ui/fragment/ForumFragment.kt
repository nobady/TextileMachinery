package com.textile.client.forum.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.game.base.mvp.BaseFragment
import com.game.base.utils.setStatusBarColor
import com.game.base.utils.toActivityNotFinish
import com.textile.client.R
import com.textile.client.forum.adapter.ForumContentAdapter
import com.textile.client.forum.adapter.ForumGridAdapter
import com.textile.client.forum.contract.ForumContract
import com.textile.client.forum.model.ForumModel
import com.textile.client.forum.presenter.ForumFragPresenterImpl
import com.textile.client.forum.ui.activity.ForumActivity
import com.textile.client.mall.contract.MallContract
import com.textile.client.mall.contract.MallPresenterImpl
import com.textile.client.mall.model.BannerModel
import com.textile.client.mall.model.CategoryModel
import com.textile.client.mall.model.HotModel
import com.textile.client.mall.ui.adapter.BannerAdapter
import kotlinx.android.synthetic.main.fragment_forum.*


/**
 * 论坛
 */
class ForumFragment : BaseFragment(), ForumContract.IForumView, MallContract.IMallView,
    ForumGridAdapter.ForumGridClickListener {
    override fun showAddProductSuccess() {
    }

    override fun setHotList(hotList: List<HotModel.ListData>) {
    }

    override fun onGridClick(position: Int) {
        var intent = Intent(activity, ForumActivity::class.java)
        when (position) {
            0 -> {
                intent.putExtra(ForumActivity.FORUM_START_CODE_KEY, ForumActivity.FORUM_TECH_EXCHANGE)
            }
            1 -> {
                intent.putExtra(ForumActivity.FORUM_START_CODE_KEY, ForumActivity.FORUM_MECHANICAL_DEMAND)
            }
            2 -> {
                intent.putExtra(ForumActivity.FORUM_START_CODE_KEY, ForumActivity.FORUM_MECHANICAL_SUPPLY)
            }
            3 -> {
                intent.putExtra(ForumActivity.FORUM_START_CODE_KEY, ForumActivity.FORUM_JOB_WANTED)
            }
            4 -> {
                intent.putExtra(ForumActivity.FORUM_START_CODE_KEY, ForumActivity.FORUM_RECRUIT)
            }
            else -> {
                intent.putExtra(ForumActivity.FORUM_START_CODE_KEY, ForumActivity.FORUM_TECH_EXCHANGE)
            }
        }
        toActivityNotFinish(intent)
    }

    override fun getListSuccess(data: ForumModel) {
        forumContentAdapter.setData(data.list)
    }

    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var forumContentAdapter: ForumContentAdapter

    override fun setBannerData(type: Int, bannerList: List<BannerModel.ListData>) {
        if (type == MallContract.BANNER_LUNTAN) {
            bannerAdapter?.imageUrls = bannerList
            bannerAdapter?.notifyDataSetChanged()
        }
    }

    override fun setCategoryData(mCategoryList: List<CategoryModel.ListData>) {

    }

    private val mForumPresenter by lazy { ForumFragPresenterImpl() }
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
        val forumGridAdapter = ForumGridAdapter(gridLayoutHelper, this)
        delegateAdapter.addAdapter(forumGridAdapter)

        val contentLayoutHelper = LinearLayoutHelper()
        forumContentAdapter = ForumContentAdapter(mForumRv, contentLayoutHelper)
        delegateAdapter.addAdapter(forumContentAdapter)
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
