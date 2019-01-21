package com.textile.client.me.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.me.model.CollectDemandModel

interface CollectDemandContract {
    interface ICollectDemandView : IBaseView {
        fun getListSuccess(data: CollectDemandModel)
    }

    interface ICollectDemandPresenter : IPresenter<ICollectDemandView> {
        fun getListDemandCollect()
    }
}