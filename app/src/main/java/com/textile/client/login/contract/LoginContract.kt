package com.textile.client.login.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by Administrator on 2019/1/9.
 */
interface LoginContract {
    interface ILoginView:IBaseView{}
    interface LoginPresenter: IPresenter<ILoginView>{
        fun startLogin(phone: String, pwd: String)
        fun forgetPwd()
    }
}