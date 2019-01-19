package com.textile.client.forum.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.forum.model.ForumModel

/**
 * Created by bo on 2019/1/16.
 */
interface ForumContract {
    interface IForumView : IBaseView {
        fun getListSuccess(data: ForumModel)
    }

    interface IForumPresenter : IPresenter<IForumView> {
        fun getForumList()
    }
}