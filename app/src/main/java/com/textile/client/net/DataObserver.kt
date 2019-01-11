package com.textile.client.net

import android.content.Context
import com.game.base.utils.toast
import com.textile.client.App
import com.textile.client.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/1/11.
 */
interface DataObserver<T>:Observer<BaseData<T>> {

//    private var mContext? = null

     fun onSuccess(data:T)

     fun onError(msg:String)

    override fun onError(e: Throwable) {
        e.message?.let {
            onError(it)
//            mContext.toast(it)
        }

        e.message?: let {
//            onError(mContext.getString(R.string.request_fail))
//            mContext.toast(R.string.request_fail)
        }
    }

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: BaseData<T>) {
        if (t.code!=200){
            onError(t.message)
        }else{
            onSuccess(t.data)
        }
    }
}