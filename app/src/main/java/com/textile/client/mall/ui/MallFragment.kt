package com.textile.client.mall.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.game.base.mvp.BaseFragment

import com.textile.client.R
import com.textile.client.mall.contract.MallContract
import com.textile.client.mall.contract.MallPresenterImpl
import kotlinx.android.synthetic.main.fragment_mall.*
import kotlinx.android.synthetic.main.fragment_mall.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MallFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MallFragment : BaseFragment(),MallContract.IMallView {

    private val mPresenter by lazy { MallPresenterImpl() }

    private lateinit var delegateAdapter: DelegateAdapter

    override fun initView(view: View) {
        mPresenter.attachView(this)

        val layoutManager =  VirtualLayoutManager(context)
        layoutManager.orientation = VirtualLayoutManager.VERTICAL
        delegateAdapter = DelegateAdapter(layoutManager)
        mall_recycler.setHasFixedSize(true)
        mall_recycler.adapter = delegateAdapter
    }

    override fun lazyLoadData() {
        mPresenter.getBannerList(MallContract.BannerType.BANNER_MALL.ordinal)
    }

    override fun getLayoutId() = R.layout.fragment_mall

    companion object {
        /**
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         */
        @JvmStatic
        fun newInstance() =
            MallFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
