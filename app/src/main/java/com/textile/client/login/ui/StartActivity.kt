package com.textile.client.login.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity() {

    override fun startLoad() {
    }

    override fun initView() {
        tv_start_login.setOnClickListener { gotoLoginActivity() }
        tv_start_register.setOnClickListener { gotoRegisterAct() }
    }

    private fun gotoRegisterAct() {

    }

    private fun gotoLoginActivity() {
        val intent = Intent()
        intent.setClass(this,LoginActivity::class.java)
        startActivity(intent)
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_start

}
