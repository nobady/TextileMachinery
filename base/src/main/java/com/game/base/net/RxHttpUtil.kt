package com.game.base.net

/**
 * Created by lff on 2019/1/11.
 */
object RxHttpUtil {

    fun config() = GlobalRxHttp.getIntance()

    fun <K> createApi(cls:Class<K>) = GlobalRxHttp.getIntance().createService(cls)


}