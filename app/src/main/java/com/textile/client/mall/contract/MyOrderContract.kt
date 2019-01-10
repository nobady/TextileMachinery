package com.textile.client.mall.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/10.
 */
interface MyOrderContract {
    interface IMyOrderView : IBaseView

    interface MyOrderPresenter : IPresenter<IMyOrderView>
}