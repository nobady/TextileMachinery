package com.textile.client.net

import android.content.Context
import android.content.Intent
import com.game.base.utils.LogUtil
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.login.model.BaseModel
import com.textile.client.login.ui.LoginActivity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by lff on 2019/1/11.
 */
abstract class DataObserver<T>(context: Context) : Observer<BaseModel<T>> {

    private var mContext = context

    abstract fun onSuccess(data: T)

    abstract fun onError(msg: String)

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
            LogUtil.logV(t.message)
            if (t.data == null) {
                onError(mContext.getString(R.string.request_fail))
            } else {
                onSuccess(t.data)
            }
        }
    }


//    override fun onNext(body: ResponseBody) {
//        val bufferedSource = body.source()
//        bufferedSource?.request(Long.MAX_VALUE)
//        val buffer = bufferedSource?.buffer()
//        val jsonBody = buffer?.clone()?.readUtf8()
//        val json = JSONObject(jsonBody)
//        val code = json.getInt("code")
//
//        if (code!=1000){
//            onError(json.getString("message"))
//        }else{
//            val type = object :TypeToken<T>(){}.rawType
//            LogUtil.logV("$type")
//            if(json.get("data") is String){
//                onSuccess((json.get("data") as T)!!)
//            }else{
//                val fromJson = Gson().fromJson<T>(json.getJSONObject("data").toString(), type)
//                onSuccess(fromJson!!)
//            }
//        }
//    }

    override fun onError(e: Throwable) {
        e.message?.let {
            onError(it)
            mContext.toast(it)
        }

        e.message ?: let {
            onError(mContext.getString(R.string.request_fail))
            mContext.toast(R.string.request_fail)
        }
    }
}