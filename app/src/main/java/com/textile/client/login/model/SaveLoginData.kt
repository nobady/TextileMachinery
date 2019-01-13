package com.textile.client.login.model

import android.content.Context

/**
 * Created by Administrator on 2019/1/13.
 */
object SaveLoginData {

    fun saveLoginToSp(context:Context,loginMode:LoginModel){
        SpUtil.putString(context,"image",loginMode.image)
        SpUtil.putString(context,"invitationCode",loginMode.invitationCode)
        SpUtil.putString(context,"phone",loginMode.phone)
        SpUtil.putString(context,"token",loginMode.token)
        SpUtil.putInt(context,"collectionNum",loginMode.collectionNum)
        SpUtil.putInt(context,"integralNum",loginMode.integralNum)
        SpUtil.putInt(context,"language",loginMode.language)
        SpUtil.putInt(context,"orderNum",loginMode.orderNum)
        SpUtil.putInt(context,"rowVersion",loginMode.rowVersion)
        SpUtil.putInt(context,"sex",loginMode.sex)
        SpUtil.putInt(context,"level",loginMode.level)
    }
}