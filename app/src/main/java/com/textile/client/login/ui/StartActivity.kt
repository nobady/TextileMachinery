package com.textile.client.login.ui

import android.content.Intent
import android.os.Handler
import com.game.base.mvp.BaseActivity
import com.game.base.utils.toActivity
import com.game.base.wdget.LoadingDialog
import com.textile.client.R
import com.textile.client.home.ui.HomeActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity() {

    override fun startLoad() {
    }

    override fun initView() {
        tv_start_login.setOnClickListener {
            testLoading()
//            gotoLoginActivity()
        }
        tv_start_register.setOnClickListener {
            toActivity(HomeActivity::class.java)
//            gotoRegisterAct()
        }
    }

    private fun testLoading() {
        val loadingDialog = LoadingDialog(this)
        loadingDialog.show()
        Handler().postDelayed({
            loadingDialog?.takeIf { it -> it.isShowing }?.dismiss()
        }, 3000)
    }

    private fun gotoRegisterAct() {

    }

    private fun gotoLoginActivity() {
        val intent = Intent()
        intent.setClass(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_start

}
