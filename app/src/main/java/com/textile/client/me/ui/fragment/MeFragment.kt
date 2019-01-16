package com.textile.client.me.ui.fragment

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.game.base.mvp.BaseFragment
import com.game.base.utils.setStatusBarColor
import com.game.base.utils.toActivityNotFinish
import com.game.base.utils.toast
import com.game.base.wdget.HeaderView
import com.textile.client.R
import com.textile.client.me.contract.MeContract
import com.textile.client.me.ui.activity.CollectionActivity
import com.textile.client.me.ui.activity.MessageActivity
import com.textile.client.me.ui.activity.MyPayTypeActivity
import com.textile.client.me.ui.activity.PersonalInfoActivity
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * Created by bo on 2019/1/6.
 */
class MeFragment : BaseFragment(), MeContract.IMeView {


    companion object {
        fun newInstance() = MeFragment().apply { }
    }

    override fun initView(view: View) {
        setStatusBarColor(R.color.meTitleColor)
        initHead()
        initEvent()
    }

    private fun initHead() {
        mMeHeadView.setTitle(resources.getString(R.string.mine))
        mMeHeadView.setImmerse(mMeHeadView.layoutParams as ViewGroup.MarginLayoutParams)
        mMeHeadView.setBackground(R.color.meTitleColor)
        mMeHeadView.showOneRightIv(R.drawable.message, object : HeaderView.RightIv2ClickListener {
            override fun onRightIv2Click(rightIv2: ImageView) {
                toast(resources.getString(R.string.message))
                toActivityNotFinish(MessageActivity::class.java)
            }
        })
    }

    override fun lazyLoadData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_me
    }

    private fun initEvent() {
        mMeAvatar.setOnClickListener {
            toActivityNotFinish(PersonalInfoActivity::class.java)
        }
        mMyOrder.setOnClickListener { toast(resources.getString(R.string.my_order)) }

        mMyCoupon.setOnClickListener { toast(resources.getString(R.string.my_coupon)) }

        mMyPayType.setOnClickListener { toActivityNotFinish(MyPayTypeActivity::class.java) }

        mMyCollection.setOnClickListener { toActivityNotFinish(CollectionActivity::class.java) }
    }
}