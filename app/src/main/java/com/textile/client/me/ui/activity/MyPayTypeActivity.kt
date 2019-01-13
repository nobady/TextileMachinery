package com.textile.client.me.ui.activity

import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_my_pay_type.*

class MyPayTypeActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        mPayHeadView.setTitle(getString(R.string.pay_type))
        mPayHeadView.showBack()
    }

    override fun initData() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_my_pay_type
    }
}
