package com.textile.client.me.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/10.
 */
interface CollectionContract {
    interface ICollectionView : IBaseView

    interface ICollectionPresenter : IPresenter<ICollectionView>{
        fun clearCollected()
    }
}