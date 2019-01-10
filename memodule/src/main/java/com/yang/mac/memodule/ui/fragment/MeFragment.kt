package com.yang.mac.memodule.ui.fragment

import android.view.View
import android.widget.ImageView
import com.game.base.mvp.BaseFragment
import com.game.base.utils.toActivity
import com.game.base.utils.toast
import com.game.base.wdget.HeaderView
import com.yang.mac.memodule.R
import com.yang.mac.memodule.contract.MeContract
import com.yang.mac.memodule.ui.activity.CollectionActivity
import com.yang.mac.memodule.ui.activity.MessageActivity
import com.yang.mac.memodule.ui.activity.MyPayTypeActivity
import com.yang.mac.memodule.ui.activity.PersonalInfoActivity
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * Created by bo on 2019/1/6.
 */
class MeFragment : BaseFragment(), MeContract.IMeView {
    override fun showLoading() {

    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object {
        fun newInstance() = MeFragment().apply { }
    }

    override fun initView(view: View) {
        initHead()
        initEvent()
    }

    private fun initHead() {
        mMeHeadView.setTitle(resources.getString(R.string.mine))
        mMeHeadView.setBackground(R.color.meTitleColor)
        mMeHeadView.showOneRightIv(R.drawable.message, object : HeaderView.RightIv2ClickListener {
            override fun onRightIv2Click(rightIv2: ImageView) {
                toast(resources.getString(R.string.message))
                toActivity(MessageActivity::class.java)
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
            toActivity(PersonalInfoActivity::class.java)
        }
        mMyOrder.setOnClickListener { toast(resources.getString(R.string.my_order)) }

        mMyCoupon.setOnClickListener { toast(resources.getString(R.string.my_coupon)) }

        mMyPayType.setOnClickListener { toActivity(MyPayTypeActivity::class.java) }

        mMyCollection.setOnClickListener { toActivity(CollectionActivity::class.java) }
    }
}