package com.textile.client.login.ui

import android.annotation.SuppressLint
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
import com.game.base.utils.LogUtil
import com.game.base.utils.PatternUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.R.id.login_headView
import com.textile.client.login.contract.RegisterContract
import com.textile.client.login.contract.RegisterPresenterImpl
import com.textile.client.net.Transformer
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import java.util.concurrent.TimeUnit

/**
 * 注册或者忘记密码
 */
class RegisterActivity : BaseActivity(),RegisterContract.IRegisterView {


    private  var type:Int?=null

    override fun resetCountView() {
        subscribe?.takeIf { subscribe?.isDisposed!! }?.dispose()
        tv_register_get_code.text = getString(R.string.get_sms_code)
    }

    private val mPresenter by lazy { RegisterPresenterImpl() }

    private var subscribe: Disposable? = null
    @SuppressLint("CheckResult")
    override fun showCountView() {

        Observable.interval(0,1, TimeUnit.SECONDS)
            .take(60)
            .compose(Transformer.switchSchedulers())
            .subscribe ({
                tv_register_get_code.text = getString(R.string.get_code_count, 60-it)
            },{
                LogUtil.logV(it.message!!)
            },{
                subscribe?.dispose()
                tv_register_get_code.isEnabled = true
            },{subscribe = it})
    }

    companion object {
        val intent_action_type = "type"
        val REGISTER_TYPE = 1
        val FORGET_PWD_TYPE = 2
    }

    override fun startLoad() {
    }

    override fun initView() {

        mPresenter.attachView(this)

        setStatusBarColor(R.color.colorAccent)

         type = intent.getIntExtra(intent_action_type, REGISTER_TYPE)
        if (type == REGISTER_TYPE) {
            initRegisterView()
        } else {
            initForgetView()
        }
    }

    private fun initForgetView() {
        register_headView.setBackground(R.color.colorPrimary)
        register_headView.setTitle(R.string.forget_pwd)
        register_headView.showBack()

        et_register_pwd.hint = getString(R.string.input_new_pwd)
        cb_register_ruler.visibility = View.GONE

        val spannedString = SpannableString(getString(R.string.forget_pwd_problem_tips))
        spannedString.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimary)),7,spannedString.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        tv_register_ruler.text = spannedString
    }

    private fun initRegisterView() {
        register_headView.setBackground(R.color.colorPrimary)
        register_headView.setTitle(R.string.login_register)
        register_headView.showBack()

        val spannedString = SpannableString(getString(R.string.register_ruler_tips))
        spannedString.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimary)),4,spannedString.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        tv_register_ruler.text = spannedString
    }

    override fun initData() {
        tv_register_login.setOnClickListener {
            if (checkInput()){
                mPresenter.register(et_register_phone.text.toString(),et_register_pwd.text.toString(),et_register_code.text.toString())
            }
        }

        tv_register_get_code.setOnClickListener {
            if (!PatternUtil.checkPhoneNum(et_register_phone.text.toString())){
                toast(getString(R.string.toast_login_input_phone))
            }else if (type== REGISTER_TYPE){
                mPresenter.getCode(et_register_phone.text.toString())
            }else{
                mPresenter.resetPwd(et_register_phone.text.toString(),et_register_pwd.text.toString(),et_register_code.text.toString())
            }
        }
    }

    private fun checkInput(): Boolean {
        if (et_register_phone.text.isEmpty() || et_register_pwd.text.isEmpty()) {
            toast(R.string.toast_input_login_error)
            return false
        }
        if (!PatternUtil.checkPhoneNum(et_register_phone.text.toString())){
            toast(getString(R.string.toast_login_input_phone))
            return false
        }
        if (et_register_pwd.text.length>20){
            toast(getString(R.string.toast_login_input_pwd_error))
            return false
        }
        if(!cb_register_ruler.isChecked){
            toast(getString(R.string.toast_check_register_ruler))
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        subscribe?.takeIf { subscribe?.isDisposed!! }?.dispose()
        mPresenter.detachView()
    }

    override fun layoutId() = R.layout.activity_register

}
