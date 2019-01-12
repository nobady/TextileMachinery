package com.textile.client.login.ui

import com.game.base.mvp.BaseActivity
import com.game.base.utils.toActivityFinish
import com.game.base.utils.toActivityNotFinish
import com.textile.client.R
import com.textile.client.home.ui.HomeActivity
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
        toHome.setOnClickListener {
            toActivityNotFinish(HomeActivity::class.java)
        }
    }

    override fun layoutId() = R.layout.activity_start

}
