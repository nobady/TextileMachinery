package com.textile.client.net

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 切换线程
 * Created by Administrator on 2019/1/11.
 */
class Transformer {

    companion object {
        fun <T> switchSchedulers(): ObservableTransformer<T, T> {
            return ObservableTransformer{
                it.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .doOnSubscribe{}
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }
}