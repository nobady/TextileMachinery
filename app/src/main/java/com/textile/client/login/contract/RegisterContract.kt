package com.textile.client.login.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by lff on 2019/1/14.
 */
interface RegisterContract {
    interface IRegisterView: IBaseView {
        fun showCountView()
        fun resetCountView()
    }
    interface RegisterPresenter: IPresenter<RegisterContract.IRegisterView> {
        fun getCode(phone:String)
        fun register(phone: String,pwd:String,code:String)
        fun resetPwd(phone: String, pwd: String, code: String)
    }
}