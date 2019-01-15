package com.textile.client.net

import android.content.Context
import com.game.base.mvp.BasePresenter
import com.game.base.mvp.IBaseView
import com.game.base.utils.LogUtil
import com.game.base.utils.toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tencent.bugly.proguard.t
import com.textile.client.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by lff on 2019/1/11.
 */
abstract class DataObserver<in T>(context: Context):Observer<ResponseBody> {

    private var mContext = context

    abstract fun onSuccess(data:T)

    abstract fun onError(msg:String)

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(body: ResponseBody) {
        val bufferedSource = body.source()
        bufferedSource?.request(Long.MAX_VALUE)
        val buffer = bufferedSource?.buffer()
        val jsonBody = buffer?.clone()?.readUtf8()
        val json = JSONObject(jsonBody)
        val code = json.getInt("code")

        if (code!=1000){
            onError(json.getString("message"))
        }else{
            val type = object :TypeToken<T>(){}.rawType
            LogUtil.logV("$type")
            if(json.get("data") is String){
                onSuccess((json.get("data") as T)!!)
            }else{
                val fromJson = Gson().fromJson<T>(json.getJSONObject("data").toString(), type)
                onSuccess(fromJson!!)
            }
        }
    }

    override fun onError(e: Throwable) {
        e.message?.let {
            onError(it)
            mContext.toast(it)
        }

        e.message?: let {
            onError(mContext.getString(R.string.request_fail))
            mContext.toast(R.string.request_fail)
        }
    }
}