package com.textile.client.mall.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter

/**
 * Created by lff on 2019/2/13.
 */
interface ClassifyInfoContract {
    interface IClassifyInfoView:IBaseView{}


    interface IClassifyInfoPresenter:IPresenter<IClassifyInfoView>{
        fun getCatagoryList()
    }
}