package com.textile.client.me.ui.activity

import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
    }

    override fun initData() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_message
    }

    private fun initTitle() {
        mMsgHeadView.showBack()
    }
}
