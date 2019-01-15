package com.textile.client.me.ui.activity

import android.content.Intent
import com.game.base.mvp.BaseActivity
import com.game.base.utils.toActivityNotFinish
import com.textile.client.R
import com.textile.client.login.model.UserPrefs
import com.textile.client.me.contract.PersonalInfoContract
import com.textile.client.me.presenter.PersonalInfoPresenterImpl
import kotlinx.android.synthetic.main.activity_personal_info.*

class PersonalInfoActivity : BaseActivity() {

    private val mPersonalPresenter: PersonalInfoContract.IPersonalInfoPresenter by lazy {
        PersonalInfoPresenterImpl()
    }

    override fun startLoad() {

    }

    override fun initView() {
        initTitle()
        initEvent()
    }

    private fun initEvent() {
        mPerPhoneRl.setOnClickListener {
            toSetActivity(0)
        }

        mPerPwdRl.setOnClickListener {
            toSetActivity(1)
        }
        mPerInfoLogout.setOnClickListener {
            mPersonalPresenter?.logout()
        }

    }

    private fun toSetActivity(startCode: Int) {
        val intent = Intent(this, SetPhoneActivity::class.java)
        intent.putExtra(SetPhoneActivity.START_CODE, startCode)
        toActivityNotFinish(intent)
    }

    private fun initTitle() {
        mPerInfoHead.showBack()
        mPerInfoHead.setTitle(resources.getString(R.string.personal_data))
    }

    override fun initData() {
        val phone = UserPrefs.getInstance.getUser().phone

        phone?.takeIf { phone.length == 11 }?.let {
            val substring = phone?.substring(4, 7)
            mPerPhoneNum.text = phone?.replace(substring, "****")
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_personal_info
    }
}
