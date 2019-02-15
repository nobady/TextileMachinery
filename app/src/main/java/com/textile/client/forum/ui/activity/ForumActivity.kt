package com.textile.client.forum.ui.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import com.game.base.mvp.BaseActivity
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.forum.contract.MechSupplyContract
import com.textile.client.forum.presenter.MechSupplyPresenterImpl
import com.textile.client.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_forum.*

class ForumActivity : BaseActivity(), MechSupplyContract.IMechSupplyView {
    private var mStartCode: Int = FORUM_TECH_EXCHANGE
    private val mForumPresenter by lazy { MechSupplyPresenterImpl() }

    companion object {
        const val FORUM_START_CODE_KEY = "Forum_start_code"
        const val FORUM_TECH_EXCHANGE = 0X252 // 技术交流
        const val FORUM_MECHANICAL_DEMAND = 0X253 // 机械需求
        const val FORUM_MECHANICAL_SUPPLY = 0X254 // 机械供给
        const val FORUM_JOB_WANTED = 0X255 // 求职
        const val FORUM_RECRUIT = 0X256 // 招聘
    }

    override fun startLoad() {

    }

    override fun initView() {
        mForumPresenter.attachView(this)
        mStartCode = intent.getIntExtra(FORUM_START_CODE_KEY, FORUM_TECH_EXCHANGE)
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
                return FragmentUtils.getForumFragment(p0, mStartCode)
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
        var title: String
        when (mStartCode) {
            FORUM_TECH_EXCHANGE -> {
                title = resources.getString(R.string.tech_exchange)
            }
            FORUM_MECHANICAL_DEMAND -> {
                title = resources.getString(R.string.mechanical_demand)
                mActSuppHead.showRightTv(resources.getString(R.string.release_demand), View.OnClickListener {
                    toast(resources.getString(R.string.release_demand))
                })
            }
            FORUM_MECHANICAL_SUPPLY -> {
                title = resources.getString(R.string.mechanical_supply)
                mActSuppHead.showRightTv(resources.getString(R.string.release_supply), View.OnClickListener {
                    toast(resources.getString(R.string.release_supply))
                })
            }
            FORUM_JOB_WANTED -> {
                title = resources.getString(R.string.job_wanted)
                mActSuppHead.showRightTv(resources.getString(R.string.release_recruit), View.OnClickListener {
                    toast(resources.getString(R.string.release_recruit))
                })
            }
            FORUM_RECRUIT -> {
                title = resources.getString(R.string.recruit)
                mActSuppHead.showRightTv(resources.getString(R.string.release_job), View.OnClickListener {
                    toast(resources.getString(R.string.release_job))
                })
            }
            else -> {
                title = resources.getString(R.string.tech_exchange)
            }
        }
        mActSuppHead.setTitle(title)
        mActSuppHead.showBack()
    }

    override fun initData() {
        when (mStartCode) {
            FORUM_TECH_EXCHANGE -> {
                mForumPresenter.loadTechExc()
            }
            FORUM_MECHANICAL_DEMAND -> {
                mForumPresenter.loadDemand()
            }
            FORUM_MECHANICAL_SUPPLY -> {
                mForumPresenter.loadSupply()
            }
            FORUM_JOB_WANTED -> {
                mForumPresenter.loadJob()
            }
            FORUM_RECRUIT -> {
                mForumPresenter.loadRecruit()
            }
            else -> {

            }
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_forum
    }

}
