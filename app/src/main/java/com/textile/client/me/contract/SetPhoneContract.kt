package com.textile.client.me.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/15.
 */
interface SetPhoneContract {
    interface ISetPhoneView : IBaseView {

    }

    interface ISetPhonePresenter : IPresenter<ISetPhoneView> {
        fun setPhoneCommit(phoneNum: String, password: String)
    }
}