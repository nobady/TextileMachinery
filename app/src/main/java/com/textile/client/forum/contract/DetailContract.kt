package com.textile.client.forum.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.forum.model.DetailModel

interface DetailContract {
    interface IDetailView : IBaseView {
        fun loadDetail(data: DetailModel)
    }

    interface IDetailPresenter : IPresenter<IDetailView> {
        fun loadDetail(itemId: String)
    }
}