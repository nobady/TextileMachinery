package com.game.base.mvp

/**
 * Created by lff on 2018/12/19.
 */
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView:V)

    fun detachView()
}