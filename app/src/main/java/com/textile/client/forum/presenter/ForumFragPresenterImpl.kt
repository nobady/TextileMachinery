package com.textile.client.forum.presenter

import android.util.Log
import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.forum.contract.ForumContract
import com.textile.client.forum.model.ForumModel
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by bo on 2019/1/16.
 */
class ForumFragPresenterImpl : BasePresenter<ForumContract.IForumView>(), ForumContract.IForumPresenter {
    override fun getForumList() {
        RequestbodyUtil.createForumListBody().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getForumList(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(
                    object : DataObserver<ForumModel>(true, getView()?.getContext()!!) {
                        override fun onSuccess(data: ForumModel) {
                            getView()?.getListSuccess(data)
                        }
                    }
                )
        }
    }

}