package com.textile.client.search.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

interface SearchContract {
    interface ISearchView : IBaseView {
        fun searchSuccess(data: ArrayList<String>)
    }

    interface ISearchPresenter : IPresenter<ISearchView> {
        fun searchUser(keyWord: String)
    }
}