package com.textile.client.me.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/15.
 */
interface SetPhoneContract {
    interface ISetPhoneView : IBaseView {
        fun showCountView()
        fun resetCountView()
    }

    interface ISetPhonePresenter : IPresenter<ISetPhoneView> {
        fun setPhoneCommit(phoneNum: String, password: String)

        fun setPasswordCommit(phoneNum: String, password: String, code: String)

        fun getCode(phoneNum: String)
    }
}