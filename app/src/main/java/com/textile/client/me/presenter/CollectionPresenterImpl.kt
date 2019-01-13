package com.textile.client.me.presenter

import com.game.base.mvp.BasePresenter
import com.textile.client.me.contract.CollectionContract

/**
 * Created by bo on 2019/1/10.
 */
class CollectionPresenterImpl : BasePresenter<CollectionContract.ICollectionView>(),
    CollectionContract.ICollectionPresenter {
    override fun clearCollected() {

    }
}