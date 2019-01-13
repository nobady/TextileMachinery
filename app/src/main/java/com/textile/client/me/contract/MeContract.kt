package com.textile.client.me.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/6.
 */
class MeContract {
    interface IMeView : IBaseView

    interface MePresenter : IPresenter<IMeView>
}