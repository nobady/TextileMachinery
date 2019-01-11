package com.game.base.mvp

import android.os.Bundle

/**
 * Created by lff on 2019/1/10.
 */
abstract class BaseMvpActivity<out P:BasePresenter<IBaseView>>:BaseActivity(),IBaseView {

    val mPresenter:P by lazy { getPresenter() }

    abstract fun getPresenter():P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}