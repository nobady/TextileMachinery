package com.yang.mac.memodule.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by bo on 2019/1/6.
 */
class MeContract {
    interface MeView :IBaseView{

    }

    class MePresenter :IPresenter<MeView>{
        override fun attachView(meView: MeView) {

        }

        override fun detachView() {
        }

    }
}