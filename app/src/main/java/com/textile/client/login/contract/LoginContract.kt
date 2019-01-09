package com.textile.client.login.contract

import com.game.base.mvp.BasePresenter
import com.game.base.mvp.IBaseView

/**
 * Created by Administrator on 2019/1/9.
 */
interface LoginContract {
    interface ILoginView:IBaseView{}
    abstract class LoginPresenter:BasePresenter<ILoginView>(){}
}