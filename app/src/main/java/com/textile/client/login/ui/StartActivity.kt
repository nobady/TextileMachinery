package com.textile.client.login.ui

import android.content.Intent
import android.text.TextUtils
import com.game.base.mvp.BaseActivity
import com.game.base.net.OkHttpConfig
import com.game.base.net.RxHttpUtil
import com.game.base.utils.setFullScreen
import com.game.base.utils.toActivityFinish
import com.game.base.utils.toActivityNotFinish
import com.textile.client.BuildConfig
import com.textile.client.R
import com.textile.client.home.ui.HomeActivity
import com.textile.client.login.LoginUtil
import com.textile.client.login.model.UserPrefs
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity() {

    override fun startLoad() {
    }

    override fun initView() {

        LoginUtil.initHttpConfig()
        setFullScreen()
        if (!TextUtils.isEmpty(UserPrefs.getInstance.getToken())) {
            toActivityFinish(HomeActivity::class.java)
            return
        }
        toHome.setOnClickListener {
            toActivityNotFinish(HomeActivity::class.java)
        }
        tv_start_login.setOnClickListener {
            toActivityFinish(LoginActivity::class.java)
        }
        tv_start_register.setOnClickListener {
            val intent = Intent()
            intent.putExtra("type", RegisterActivity.REGISTER_TYPE)
            intent.setClass(this, RegisterActivity::class.java)
            toActivityFinish(intent)
        }
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_start

}
