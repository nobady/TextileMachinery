package com.game.base.net

import com.game.base.utils.LogUtil
import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import org.json.JSONObject

/**
 * Created by Administrator on 2019/1/5.
 */
class DefaultLogInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        try {
            val startReqTime = System.currentTimeMillis()
            val response = chain.proceed(request)
            val endReqTime = System.currentTimeMillis()

            val time = endReqTime-startReqTime

            val bufferedSource = response.body()?.source()
            bufferedSource?.request(Long.MAX_VALUE)
            val buffer = bufferedSource?.buffer()

            val logStr = "method->${request.method()}\n" +
                    "network code->${response.code()}\n" +
                    "url->${request.url()}\n" +
                    "time->$time\n" +
                    "request header->${request.headers()}\n" +
                    "request params->${bodyToString(request.body())}\n" +
                    "response body->${buffer?.clone()?.readUtf8()}"

            LogUtil.logI(logStr)

            return response
        }catch (e:Exception){
            throw e
        }

    }

    private fun bodyToString(body: RequestBody?): String? {
        val buffer = Buffer()
        body?.writeTo(buffer)
        return buffer.readUtf8()
    }
}