package com.textile.client.net

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/1/11.
 */
abstract class DataObserver<T>:Observer<BaseData<T>> {

    abstract fun onSuccess(data:T)

    abstract fun onError(msg:String)

    override fun onError(e: Throwable) {
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