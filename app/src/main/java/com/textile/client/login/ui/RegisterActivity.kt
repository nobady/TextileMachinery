package com.textile.client.login.ui

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.view.View
import com.game.base.mvp.BaseActivity
import com.textile.client.R
import com.textile.client.R.id.login_headView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

/**
 * 注册或者忘记密码
 */
class RegisterActivity : BaseActivity() {

    companion object {
        val intent_action_type = "type"
        val REGISTER_TYPE = 1
        val FORGET_PWD_TYPE = 2
    }

    override fun startLoad() {
    }

    override fun initView() {
        val type = intent.getIntExtra(intent_action_type, REGISTER_TYPE)
        if (type == REGISTER_TYPE) {
            initRegisterView()
        } else {
            initForgetView()
        }
    }

    private fun initForgetView() {
        login_headView.setBackground(R.color.colorPrimary)
        login_headView.setTitle(R.string.forget_pwd)
        login_headView.showBack()

        et_register_pwd.hint = getString(R.string.input_new_pwd)
        cb_register_ruler.visibility = View.GONE

        val spannedString = SpannableString(getString(R.string.forget_pwd_problem_tips))
        spannedString.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimary)),7,spannedString.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        tv_register_get_code.text = spannedString
    }

    private fun initRegisterView() {
        login_headView.setBackground(R.color.colorPrimary)
        login_headView.setTitle(R.string.login_register)
        login_headView.showBack()

        val spannedString = SpannableString(getString(R.string.register_ruler_tips))
        spannedString.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimary)),4,spannedString.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        tv_register_get_code.text = spannedString
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_register

}
