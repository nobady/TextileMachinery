package com.textile.client.net

import android.content.Context
import android.content.Intent
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.login.ui.LoginActivity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/1/11.
 */
abstract class DataObserver<T>(isShowErrorToast: Boolean, context: Context) : Observer<BaseModel<T>> {

    private var mContext = context
    private val mIsShowErrorToast = isShowErrorToast

    abstract fun onSuccess(data: T)

    open fun onError(msg: String){}

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: BaseModel<T>) {
        if (t.code == 1006 || t.message == "token失效") {
            val intent = Intent(mContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            mContext.startActivity(intent)
        }
        if (t.code != 1000) {
            onError(t.message)
        } else {
            onSuccess(t.data)
        }
    }

    override fun onError(e: Throwable) {
        e.message?.let {
            onError(it)
            if (mIsShowErrorToast)
                mContext.toast(it)
        }

        e.message ?: let {
            onError(mContext.getString(R.string.request_fail))
            if (mIsShowErrorToast)
                mContext.toast(R.string.request_fail)
        }
    }
}