package com.game.base.mvp


/**
 * Created by lff on 2018/12/19.
 */
interface IBaseView {
    fun showLoading()

    fun dismissLoading()

    fun getContext(): BaseActivity
}