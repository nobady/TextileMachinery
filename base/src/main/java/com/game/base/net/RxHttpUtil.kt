package com.game.base.net

/**
 * Created by lff on 2019/1/11.
 */
object RxHttpUtil {


    fun config() = GlobalRxHttp.getInstance()

    fun <K> createApi(cls:Class<K>) = config().createService(cls)


}