package com.textile.client.login

import android.text.TextUtils
import com.game.base.net.OkHttpConfig
import com.game.base.net.RxHttpUtil
import com.textile.client.BuildConfig
import com.textile.client.login.model.UserPrefs

/**
 * Created by lff on 2019/1/15.
 */
object LoginUtil {

     fun initHttpConfig() {

        val okHttpClientBuilder = OkHttpConfig.getInstance().Builder().setDebugMode(BuildConfig.DEBUG)

         UserPrefs.getInstance.getToken().let {
             if (!TextUtils.isEmpty(it)){
                 okHttpClientBuilder.clearHeadMap().addHead("Authorization",it)
             }
         }
        RxHttpUtil.config().setClient(okHttpClientBuilder.build()).setBaseUrl("http://haroldchan.cn:8080/api/")
    }
}