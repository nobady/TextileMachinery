package com.textile.client.me.ui.activity

import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_set_phone.*

class SetPhoneActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
    }

    private fun initTitle() {
        mSetPhoneHead.showBack()
        mSetPhoneHead.setTitle(resources.getString(R.string.set_phone))
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_set_phone
    }
}
