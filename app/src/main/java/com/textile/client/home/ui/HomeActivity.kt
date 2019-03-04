package com.textile.client.home.ui

import android.support.design.widget.BottomNavigationView
import com.game.base.mvp.BaseActivity
import com.game.base.utils.setFullScreen
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.forum.ui.fragment.ForumFragment
import com.textile.client.mall.ui.MallFragment
import com.textile.client.me.ui.fragment.MeFragment
import com.textile.client.shop_car.ui.ShopCarFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private var clickTime: Long = 0

    override fun startLoad() {
    }

    override fun initView() {
        setFullScreen()

        navigation.onNavigationItemSelectedListener = mOnNavigationItemSelectedListener
        navigation.enableAnimation(false)
        navigation.enableShiftingMode(false)

        changeOrNewFragment(getString(R.string.frag_mall))

        fab_add.setOnClickListener {
            val bottomPopup = BottomPopup(this)
            bottomPopup.showUpView(it)
        }
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_home

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_mall -> {
                changeOrNewFragment(getString(R.string.frag_mall))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_forum -> {
                changeOrNewFragment(getString(R.string.frag_forum))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shop_car -> {
                changeOrNewFragment(getString(R.string.frag_shop_car))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_me -> {
                changeOrNewFragment(getString(R.string.frag_me))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun changeOrNewFragment(tag: String) {
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        val transaction = supportFragmentManager.beginTransaction()

        fragment ?: let {
            fragment = when (tag) {
                "mall" -> MallFragment.newInstance()
                "forum" -> ForumFragment.newInstance()
                "shop_car" -> ShopCarFragment.newInstance()
                "me" -> MeFragment.newInstance()
                else -> MallFragment.newInstance()
            }
        }
        transaction.replace(R.id.fragment, fragment!!, tag)
        transaction.commit()
    }

    override fun onBackPressed() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            toast(getString(R.string.again_back))
            clickTime = System.currentTimeMillis()
        } else {
            finish()
        }
    }
}
