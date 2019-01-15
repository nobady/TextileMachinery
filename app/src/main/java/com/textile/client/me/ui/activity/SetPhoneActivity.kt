package com.textile.client.me.ui.activity

import com.game.base.mvp.BaseActivity
import com.game.base.utils.PatternUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.me.contract.SetPhoneContract
import com.textile.client.me.presenter.SetPhonePresenterImpl
import kotlinx.android.synthetic.main.activity_set_phone.*

class SetPhoneActivity : BaseActivity(), SetPhoneContract.ISetPhoneView {
    private val mSetPhonePresenter: SetPhoneContract.ISetPhonePresenter by lazy { SetPhonePresenterImpl() }
    override fun startLoad() {

    }

    override fun initView() {
        mSetPhonePresenter.attachView(this)
        initTitle()
        initEvent()
    }

    private fun initEvent() {
        mSetPhoneCommit.setOnClickListener {
            val phone = mSetPhoneEt.text.toString().trim()
            val pwd = mSetPwdEt.text.toString().trim()
            if (checkInput()) {
                mSetPhonePresenter.setPhoneCommit(phone, pwd)
            }
        }
    }

    private fun checkInput(): Boolean {
        if (mSetPhoneEt.text.isEmpty() || mSetPwdEt.text.isEmpty()) {
            toast(R.string.toast_input_login_error)
            return false
        }
        if (!PatternUtil.checkPhoneNum(mSetPhoneEt.text.toString())) {
            toast(getString(R.string.toast_login_input_phone))
            return false
        }
        return true
    }

    private fun initTitle() {
        mSetPhoneHead.showBack()
        mSetPhoneHead.setTitle(resources.getString(R.string.set_phone))
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_set_phone
    }
}
