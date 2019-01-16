package com.textile.client.login.model

import com.textile.client.utils.SharePrefsHelps

/**
 * Created by lff on 2019/1/14.
 */
class UserPrefs private constructor() {


    private var sharePrefsHelps: SharePrefsHelps = SharePrefsHelps("User_info_sp")

    companion object {
        val getInstance = Singleton.holder
    }

    private object Singleton {
        val holder = UserPrefs()
    }

    fun setUser(loginMode: LoginModel) {
        sharePrefsHelps.putString("image", loginMode.image)
        sharePrefsHelps.putString("invitationCode", loginMode.invitationCode)
        sharePrefsHelps.putString("phone", loginMode.phone)
        sharePrefsHelps.putString("token", loginMode.token)
        sharePrefsHelps.putInt("collectionNum", loginMode.collectionNum)
        sharePrefsHelps.putString("integralNum", loginMode.integralNum)
        sharePrefsHelps.putInt("language", loginMode.language)
        sharePrefsHelps.putInt("orderNum", loginMode.orderNum)
        sharePrefsHelps.putString("rowVersion", loginMode.rowVersion)
        sharePrefsHelps.putString("sex", loginMode.sex)
        sharePrefsHelps.putString("level", loginMode.level)
    }

    fun getUser(): LoginModel {
        val image = sharePrefsHelps.getString("image")
        val invitationCode = sharePrefsHelps.getString("invitationCode")
        val phone = sharePrefsHelps.getString("phone")
        val token = sharePrefsHelps.getString("token")
        val collectionNum = sharePrefsHelps.getInt("collectionNum")
        val integralNum = sharePrefsHelps.getString("integralNum")
        val language = sharePrefsHelps.getInt("language")
        val orderNum = sharePrefsHelps.getInt("orderNum")
        val rowVersion = sharePrefsHelps.getString("rowVersion")
        val sex = sharePrefsHelps.getString("sex")
        val level = sharePrefsHelps.getString("level")

        return LoginModel(
            phone,
            sex,
            image,
            invitationCode,
            level,
            language,
            integralNum,
            rowVersion,
            token,
            collectionNum,
            orderNum
        )
    }

    fun updateToken(token: String) {
        sharePrefsHelps.putString("token", token)
    }

    fun getToken(): String {
        return sharePrefsHelps.getString("token")
    }

    fun getLanguage():Int{
        return sharePrefsHelps.getInt("language")
    }

}