package com.textile.client.publish

import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_publish_demand.*

class PublishDemandActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
    }

    private fun initTitle() {
        mPublishDemandHead.showBack()
        mPublishDemandHead.setTitle(resources.getString(R.string.supply_publish))
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_publish_demand
    }
}
