package com.textile.client.me.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/14.
 */
interface PersonalInfoContract {
    interface IPersonalInfoView : IBaseView

    interface IPersonalInfoPresenter : IPresenter<IPersonalInfoView>{
        fun logout()
    }
}