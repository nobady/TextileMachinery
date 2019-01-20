package com.textile.client.me.ui.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.game.base.mvp.BaseActivity
import com.textile.client.R
import com.textile.client.me.contract.CollectionContract
import com.textile.client.me.presenter.CollectionPresenterImpl
import com.textile.client.me.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_collection.*

class CollectionActivity : BaseActivity(), CollectionContract.ICollectionView {

    private val collectionPresenter: CollectionContract.ICollectionPresenter by lazy { CollectionPresenterImpl() }

    override fun startLoad() {

    }

    override fun initView() {
        collectionPresenter.attachView(this)
        initTitle()
        initTab()
    }

    private fun initTitle() {
        mCollHead.setTitle(resources.getString(R.string.my_collection))
        mCollHead.showBack()
        mCollHead.showRightTv(
            resources.getString(R.string.empty),
            View.OnClickListener {
                collectionPresenter.clearCollected()
            })
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_collection
    }

    private fun initTab() {
        val tabArray = resources.getStringArray(R.array.collectionTabs)
        mCollVp.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return FragmentUtils.getFragment(position)
            }

            override fun getCount(): Int {
                return tabArray.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return tabArray[position]
            }

        }
        mCollTab.setupWithViewPager(mCollVp)
    }
}
