package com.game.base.mvp

import android.content.Context

/**
 * Created by lff on 2018/12/19.
 */
interface IBaseView {
    fun showLoading()

    fun dismissLoading()

    fun getContext(): Context
}