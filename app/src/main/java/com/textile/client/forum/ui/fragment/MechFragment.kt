package com.textile.client.forum.ui.fragment


import android.os.Bundle
import android.view.View
import com.game.base.mvp.BaseFragment
import com.textile.client.R
import com.textile.client.forum.contract.CommunityContract
import com.textile.client.forum.model.*
import com.textile.client.forum.presenter.CommunityPresenterImpl
import com.textile.client.forum.ui.activity.ForumActivity

/**
 * 论坛--整经机械
 */
class MechFragment : BaseFragment(), CommunityContract.ICommunityView {
    override fun loadTechExcSuccess(data: TechModel) {

    }

    override fun loadDemandSuccess(data: DemandModel) {

    }

    override fun loadSupplySuccess(data: SupplyModel) {

    }

    override fun loadJobSuccess(data: ApplyJobModel) {

    }

    override fun loadRecruitSuccess(data: RecruitModel) {

    }

    private val mCommunityPresenter by lazy { CommunityPresenterImpl() }
    private var mStartCode: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mStartCode = it.getInt(ForumActivity.FORUM_START_CODE_KEY)
        }
    }
    override fun initView(view: View) {
        mCommunityPresenter.attachView(this)
    }

    override fun lazyLoadData() {

    }

    private fun loadData() {
        when (mStartCode) {
            ForumActivity.FORUM_TECH_EXCHANGE -> {
                mCommunityPresenter.loadTechExc(mStartCode!!)
            }
            ForumActivity.FORUM_MECHANICAL_DEMAND -> {
                mCommunityPresenter.loadDemand(mStartCode!!)
            }
            ForumActivity.FORUM_MECHANICAL_SUPPLY -> {
                mCommunityPresenter.loadSupply(mStartCode!!)
            }
            ForumActivity.FORUM_JOB_WANTED -> {
                mCommunityPresenter.loadJob(mStartCode!!)
            }
            ForumActivity.FORUM_RECRUIT -> {
                mCommunityPresenter.loadRecruit(mStartCode!!)
            }
            else -> {

            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_newest
    }

    companion object {
        @JvmStatic
        fun newInstance(startCode: Int) =
            MechFragment().apply {
                arguments = Bundle().apply {
                    putInt(ForumActivity.FORUM_START_CODE_KEY, startCode)
                }
            }
    }
}
