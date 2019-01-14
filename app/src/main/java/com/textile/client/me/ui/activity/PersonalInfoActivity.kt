package com.textile.client.me.ui.activity

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
            toActivityNotFinish(SetPhoneActivity::class.java)
        }
        mPerInfoLogout.setOnClickListener {
            mPersonalPresenter?.logout()
        }

    }

    private fun initTitle() {
        mPerInfoHead.showBack()
        mPerInfoHead.setTitle(resources.getString(R.string.personal_data))
    }

    override fun initData() {
        val phone = UserPrefs.getInstance.getUser().phone
        val substring = phone.substring(4, 7)
        mPerPhoneNum.text = phone.replace(substring, "****")
    }

    override fun layoutId(): Int {
        return R.layout.activity_personal_info
    }
}
