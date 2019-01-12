package com.textile.client.login.ui

import com.game.base.mvp.BaseActivity
import com.game.base.utils.toActivityFinish
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity() {

    override fun startLoad() {
    }

    override fun initView() {
        tv_start_login.setOnClickListener {
            toActivityFinish(LoginActivity::class.java)
        }
        tv_start_register.setOnClickListener {
//            toActivity(HomeActivity::class.java)
//            gotoRegisterAct()
        }
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_start

}
