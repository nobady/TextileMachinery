package com.textile.client.login.ui

import com.game.base.mvp.BaseActivity
import com.game.base.utils.PatternUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.R.id.et_login_phone
import com.textile.client.R.id.et_login_pwd
import com.textile.client.login.contract.LoginContract
import com.textile.client.login.contract.LoginPresenterImpl
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by lff on 2019/1/9.
 */
class LoginActivity : BaseActivity(),LoginContract.ILoginView {


    private val loginPresenter:LoginContract.LoginPresenter by lazy { LoginPresenterImpl() }

    override fun startLoad() {
    }

    override fun initView() {

        loginPresenter.attachView(this)

        login_headView.setBackground(R.color.colorPrimary)
        login_headView.setTitle(R.string.login_login)

        tv_login_login.setOnClickListener {
            if ( checkInput() ) { loginPresenter.startLogin(et_login_phone.text.toString(),et_login_pwd.text.toString()) }
        }

        tv_login_forget_pwd.setOnClickListener {
            loginPresenter.forgetPwd()
        }
    }

    override fun initData() {
    }

    private fun checkInput(): Boolean {
        if (et_login_phone.text.isEmpty() || et_login_pwd.text.isEmpty()) {
            toast(R.string.toast_input_login_error)
            return false
        }
        if (!PatternUtil.checkPhoneNum(et_login_phone.text.toString())){
            toast(getString(R.string.toast_login_input_phone))
            return false
        }
        if (et_login_pwd.text.length>20){
            toast(getString(R.string.toast_login_input_pwd_error))
            return false
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detachView()
    }

    override fun layoutId() = R.layout.activity_login
}