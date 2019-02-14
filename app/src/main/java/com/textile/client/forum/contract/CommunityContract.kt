package com.textile.client.forum.contract

import com.game.base.mvp.IBaseView
import com.game.base.mvp.IPresenter
import com.textile.client.forum.model.*

interface CommunityContract {
    interface ICommunityView : IBaseView {
        fun loadTechExcSuccess(data: TechModel)

        fun loadDemandSuccess(data: DemandModel)

        fun loadSupplySuccess(data: SupplyModel)

        fun loadJobSuccess(data: ApplyJobModel)

        fun loadRecruitSuccess(data: RecruitModel)
    }

    interface ICommunityPresenter : IPresenter<ICommunityView> {
        fun loadTechExc(startCode: Int)

        fun loadDemand(startCode: Int)

        fun loadSupply(startCode: Int)

        fun loadJob(startCode: Int)

        fun loadRecruit(startCode: Int)
    }
}