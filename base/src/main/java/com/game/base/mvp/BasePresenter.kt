package com.game.base.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2018/12/19.
 */
open class BasePresenter<T: IBaseView>: IPresenter<T> {
    private var mRootView:T? = null

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun attachView(mRootView: T) {
        this.mRootView = mRootView
    }

    override fun detachView() {
        mRootView = null

        if (!compositeDisposable.isDisposed){
            compositeDisposable.clear()
        }
    }

    private val isViewAttached:Boolean get() = mRootView!=null

    fun getView() = if (checkViewAttached())  mRootView else null

    private fun checkViewAttached(): Boolean {
        if (!isViewAttached) throw MvpViewNoAttachedException()
        return true
    }

    fun addSubscription(d:Disposable){
        compositeDisposable.add(d)
    }

    private class MvpViewNoAttachedException internal constructor():RuntimeException("请调用IPresenter.attachView(IBaseView)")
}