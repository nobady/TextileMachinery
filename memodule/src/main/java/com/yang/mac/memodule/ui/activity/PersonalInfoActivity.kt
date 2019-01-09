package com.yang.mac.memodule.ui.activity

import com.game.base.mvp.BaseActivity
import com.yang.mac.memodule.R
import kotlinx.android.synthetic.main.activity_personal_info.*

class PersonalInfoActivity : BaseActivity() {
    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
    }

    private fun initTitle() {
        mPerInfoHead.showBack()
        mPerInfoHead.setBackground(R.color.meTitleColor)
        mPerInfoHead.setTitle(resources.getString(R.string.personal_data))
    }

    override fun initData() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_personal_info
    }
}
