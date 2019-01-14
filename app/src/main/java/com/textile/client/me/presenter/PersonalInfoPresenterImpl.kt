package com.textile.client.me.presenter

import com.game.base.mvp.BasePresenter
import com.textile.client.me.contract.PersonalInfoContract

/**
 * Created by bo on 2019/1/14.
 */
class PersonalInfoPresenterImpl : BasePresenter<PersonalInfoContract.IPersonalInfoView>(),
    PersonalInfoContract.IPersonalInfoPresenter {
    override fun logout() {

    }
}