package com.textile.client.forum.ui.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.game.base.mvp.BaseActivity
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.me.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_mech_supply.*

class MechSupplyActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
        initTabs()
    }

    private fun initTabs() {
        val tabs = resources.getStringArray(R.array.mechSupplyTabs)
        mActSuppVp.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getCount(): Int {
                return tabs.size
            }

            override fun getItem(p0: Int): Fragment {
                return FragmentUtils.getFragment(p0)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return tabs[position]
            }
        }
        mActSuppTab.setupWithViewPager(mActSuppVp)
        val tab = mActSuppTab.newTab().setIcon(R.drawable.collection)
        mActSuppTab.addTab(tab, tabs.size)

        mActSuppTab.addOnTabSelectedListener(object : TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {

            }
        })
    }

    private fun initTitle() {
        mActSuppHead.setTitle(resources.getString(R.string.mechanical_supply))
        mActSuppHead.showBack()
        mActSuppHead.showRightTv(resources.getString(R.string.release_demand), View.OnClickListener {
            toast(resources.getString(R.string.release_demand))
        })
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_mech_supply
    }

}
