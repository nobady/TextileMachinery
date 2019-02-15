package com.textile.client.forum.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

interface MechSupplyContract {
    interface IMechSupplyView : IBaseView {}
    interface IMechSupplyPresenter : IPresenter<IMechSupplyView> {

        fun loadTechExc()

        fun loadDemand()

        fun loadSupply()

        fun loadJob()

        fun loadRecruit()
    }
}