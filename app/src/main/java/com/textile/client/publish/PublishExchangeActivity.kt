package com.textile.client.publish

import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_publish_exchange.*

class PublishExchangeActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
    }

    private fun initTitle() {
        mPublishHead.showBack()
        mPublishHead.setTitle(resources.getString(R.string.exchange_publish))
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_publish_exchange
    }
}
