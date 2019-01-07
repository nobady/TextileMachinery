package com.yang.mac.memodule.ui.fragment

import android.view.View
import android.widget.ImageView
import com.game.base.mvp.BaseFragment
import com.game.base.utils.toast
import com.game.base.wdget.HeaderView
import com.yang.mac.memodule.R
import com.yang.mac.memodule.contract.MeContract
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * Created by bo on 2019/1/6.
 */
class MeFragment : BaseFragment(), MeContract.MeView {
    companion object {
        fun newInstance() = MeFragment().apply {  }
    }

    override fun initView(view: View) {
        initHead()
        initEvent()
    }

    private fun initHead() {
        mMeHeadView.setBackground(R.color.meTitleColor)
        mMeHeadView.showOneRightIv(R.drawable.message, object : HeaderView.RightIv2ClickListener {
            override fun onRightIv2Click(rightIv2: ImageView) {
                toast("消息")
            }
        })
    }

    override fun lazyLoadData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_me
    }

    private fun initEvent() {
        mMyOrder.setOnClickListener { toast("我的订单") }

        mMyCoupon.setOnClickListener { toast("我的优惠券") }

        mMyPayType.setOnClickListener { toast("我的支付方式") }
    }
}