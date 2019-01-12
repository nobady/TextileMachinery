package com.yang.mac.memodule.ui.activity

import android.net.Uri
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.game.base.mvp.BaseActivity
import com.game.base.utils.toast
import com.yang.mac.memodule.R
import com.yang.mac.memodule.contract.CollectionContract
import com.yang.mac.memodule.presenter.CollectionPresenterImpl
import com.yang.mac.memodule.ui.fragment.*
import com.yang.mac.memodule.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_collection.*

class CollectionActivity : BaseActivity(), TechExcFragment.OnFragmentInteractionListener,
    DemandFragment.OnFragmentInteractionListener, SupplyFragment.OnFragmentInteractionListener,
    RecruitFragment.OnFragmentInteractionListener, JobWantFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    private val collectionPresenter: CollectionContract.ICollectionPresenter by lazy { CollectionPresenterImpl() }

    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
        initTab()
    }

    private fun initTitle() {
        mCollHead.setTitle(resources.getString(R.string.my_collection))
        mCollHead.showBack()
        mCollHead.showRightTv(
            resources.getString(R.string.empty),
            View.OnClickListener { toast(resources.getString(R.string.empty)) })
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
