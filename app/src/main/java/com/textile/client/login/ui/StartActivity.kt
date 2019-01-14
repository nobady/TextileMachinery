package com.textile.client.login.ui

import android.content.Intent
import android.text.TextUtils
import com.game.base.mvp.BaseActivity
import com.game.base.net.OkHttpConfig
import com.game.base.net.RxHttpUtil
import com.game.base.utils.toActivityFinish
import com.game.base.utils.toActivityNotFinish
import com.textile.client.BuildConfig
import com.textile.client.R
import com.textile.client.home.ui.HomeActivity
import com.textile.client.login.model.UserPrefs
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity() {

    override fun startLoad() {
    }

    override fun initView() {

        initHttp()

        if (!TextUtils.isEmpty( UserPrefs.getInstance.getToken())) {
            toActivityFinish(HomeActivity::class.java)
            return
        }
        tv_start_login.setOnClickListener {
            toActivityFinish(LoginActivity::class.java)
        }
        tv_start_register.setOnClickListener {
            val intent = Intent()
            intent.putExtra("type",RegisterActivity.REGISTER_TYPE)
            intent.setClass(this,RegisterActivity::class.java)
            toActivityFinish(intent)
        }
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_start


    private fun initHttp() {

        val headerMap = HashMap<String,String>()
        headerMap["Authorization"] = UserPrefs.getInstance.getToken()

        val okHttpClient = OkHttpConfig.getInstance().Builder().apply {
            isDebug = BuildConfig.DEBUG
            headMap = headerMap
        }.build()

        RxHttpUtil.config().setClient(okHttpClient).setBaseUrl("http://haroldchan.cn:8080/api/")
    }
}
