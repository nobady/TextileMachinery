package com.textile.client.me.ui.activity

import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_personal_info.*

class PersonalInfoActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
    }

    private fun initTitle() {
        mPerInfoHead.showBack()
        mPerInfoHead.setTitle(resources.getString(R.string.personal_data))
    }

    override fun initData() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_personal_info
    }
}
