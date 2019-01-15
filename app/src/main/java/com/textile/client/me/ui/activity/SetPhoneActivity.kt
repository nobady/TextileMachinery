package com.textile.client.me.ui.activity

import android.annotation.SuppressLint
import android.view.View.GONE
import android.view.View.VISIBLE
import com.game.base.mvp.BaseActivity
import com.game.base.utils.LogUtil
import com.game.base.utils.PatternUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.me.contract.SetPhoneContract
import com.textile.client.me.presenter.SetPhonePresenterImpl
import com.textile.client.net.Transformer
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_set_phone.*
import java.util.concurrent.TimeUnit

class SetPhoneActivity : BaseActivity(), SetPhoneContract.ISetPhoneView {
    override fun resetCountView() {
        subscribe?.takeIf { subscribe?.isDisposed!! }?.dispose()
        mSetPhoneGetCode.text = getString(R.string.get_sms_code)
    }

    private var subscribe: Disposable? = null

    @SuppressLint("CheckResult")
    override fun showCountView() {
        Observable.interval(0, 1, TimeUnit.SECONDS)
            .take(60)
            .compose(Transformer.switchSchedulers())
            .subscribe({
                mSetPhoneGetCode.text = getString(R.string.get_code_count, 60 - it)
            }, {
                LogUtil.logV(it.message!!)
            }, {
                subscribe?.dispose()
                mSetPhoneGetCode.isEnabled = true
            }, { subscribe = it })
    }

    companion object {
        const val START_CODE = "set_phone_start_code"
    }

    private var mStartCode = 0
    private val mSetPhonePresenter: SetPhoneContract.ISetPhonePresenter by lazy { SetPhonePresenterImpl() }
    override fun startLoad() {

    }

    override fun initView() {
        mSetPhonePresenter.attachView(this)
        initParam()
        initEvent()
    }

    private fun initParam() {
        mStartCode = intent.getIntExtra(START_CODE, 0)
        when (mStartCode) {
            0 -> { //修改手机页面
                mSetPhoneCodeLl.visibility = GONE
                initTitle(resources.getString(R.string.set_phone))
            }
            1 -> {//修改密码页面
                mSetPhoneCodeLl.visibility = VISIBLE
                initTitle(resources.getString(R.string.set_password))
            }
            else -> { //默认修改手机
            }
        }
    }

    private fun initEvent() {
        mSetPhoneCommit.setOnClickListener {
            val phone = mSetPhoneEt.text.toString().trim()
            val pwd = mSetPwdEt.text.toString().trim()
            when (mStartCode) {
                0 -> {
                    if (checkInput()) {
                        mSetPhonePresenter.setPhoneCommit(phone, pwd)
                    }
                }
                1 -> {
                    if (checkInput()) {
                        val code = mSetPhoneCodeEt.text.toString().trim()
                        if (code.isEmpty()) {
                            toast(resources.getString(R.string.register_input_code))
                        } else {
                            mSetPhonePresenter.setPasswordCommit(phone, pwd, code)
                        }
                    }
                }
            }


        }

        mSetPhoneGetCode.setOnClickListener {
            val phone = mSetPhoneEt.text.toString().trim()
            phone.takeIf { !checkPhone(phone) }?.apply {
                mSetPhonePresenter.getCode(this)
            }
        }
    }

    private fun checkInput(): Boolean {
        if (mSetPhoneEt.text.isEmpty() || mSetPwdEt.text.isEmpty()) {
            toast(R.string.toast_input_login_error)
            return false
        }
        if (checkPhone(mSetPhoneEt.text.toString())) {
            return false
        }
        return true
    }

    private fun checkPhone(phone: String): Boolean {
        if (!PatternUtil.checkPhoneNum(phone)) {
            toast(getString(R.string.toast_login_input_phone))
            return true
        }
        return false
    }

    private fun initTitle(title: String) {
        mSetPhoneHead.showBack()
        mSetPhoneHead.setTitle(title)
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_set_phone
    }

    override fun onDestroy() {
        super.onDestroy()
        subscribe?.takeIf { subscribe?.isDisposed!! }?.dispose()
    }
}
