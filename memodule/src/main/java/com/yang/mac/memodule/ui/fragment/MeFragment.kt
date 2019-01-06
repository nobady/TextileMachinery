package com.yang.mac.memodule.ui.fragment

import android.view.View
import com.game.base.mvp.BaseFragment
import com.yang.mac.memodule.R
import com.yang.mac.memodule.contract.MeContract

/**
 * Created by bo on 2019/1/6.
 */
class MeFragment : BaseFragment(), MeContract.MeView {
    override fun initView(view: View) {

    }

    override fun lazyLoadData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_me
    }
}