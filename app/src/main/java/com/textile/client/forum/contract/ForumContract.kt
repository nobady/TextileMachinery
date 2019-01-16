package com.textile.client.forum.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/16.
 */
interface ForumContract {
    interface IForumView : IBaseView {

    }

    interface IForumPresenter : IPresenter<IForumView> {
        fun getForumList()
    }
}