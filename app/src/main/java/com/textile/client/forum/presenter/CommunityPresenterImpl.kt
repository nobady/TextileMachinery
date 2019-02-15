package com.textile.client.forum.presenter

import android.util.Log
import com.game.base.mvp.BasePresenter
import com.game.base.net.RxHttpUtil
import com.textile.client.forum.contract.CommunityContract
import com.textile.client.forum.model.*
import com.textile.client.net.DataObserver
import com.textile.client.net.NetApi
import com.textile.client.net.Transformer
import com.textile.client.utils.RequestbodyUtil

class CommunityPresenterImpl : BasePresenter<CommunityContract.ICommunityView>(),
    CommunityContract.ICommunityPresenter {

    override fun loadTechExc(startCode: Int) {
        RequestbodyUtil.createCollectDemandList().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getListTechnicalCommunication(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<TechModel>(true, getView()?.getContext()!!) {
                    override fun onSuccess(data: TechModel) {
                        Log.e("CommunityPresenterImpl", " loadTechExc == $data")
                        getView()?.loadTechExcSuccess(data)
                    }
                })
        }
    }

    override fun loadDemand(startCode: Int) {
        RequestbodyUtil.createCollectDemandList().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getListDemand(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<DemandModel>(true, getView()?.getContext()!!) {
                    override fun onSuccess(data: DemandModel) {
                        data?.run {
                            Log.e("CommunityPresenterImpl", " loadDemand == $data")
                        }
                    }
                })
        }
    }

    override fun loadSupply(startCode: Int) {
        RequestbodyUtil.createCollectDemandList().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getListSupply(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<SupplyModel>(true, getView()?.getContext()!!) {
                    override fun onSuccess(data: SupplyModel) {
                        data?.run {
                            Log.e("CommunityPresenterImpl", " loadSupply == $data")
                        }
                    }
                })
        }
    }

    override fun loadJob(startCode: Int) {
        RequestbodyUtil.createCollectDemandList().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getListApplyJob(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<ApplyJobModel>(true, getView()?.getContext()!!) {
                    override fun onSuccess(data: ApplyJobModel) {
                        data?.run {
                            Log.e("CommunityPresenterImpl", " loadJob == $data")
                        }
                    }
                })
        }
    }

    override fun loadRecruit(startCode: Int) {
        RequestbodyUtil.createCollectDemandList().let {
            RxHttpUtil.createApi(NetApi::class.java)
                ?.getListRecruitment(it)
                ?.compose(Transformer.switchSchedulers())
                ?.subscribe(object : DataObserver<RecruitModel>(true, getView()?.getContext()!!) {
                    override fun onSuccess(data: RecruitModel) {
                        data?.run {
                            Log.e("CommunityPresenterImpl", " loadRecruit == $data")
                        }
                    }
                })
        }
    }
}