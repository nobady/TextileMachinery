package com.textile.client.home.ui

import android.support.design.widget.BottomNavigationView
import com.game.base.mvp.BaseActivity
import com.game.base.utils.setFullScreen
import com.textile.client.R
import com.textile.client.forum.ui.ForumFragment
import com.textile.client.mall.ui.MallFragment
import com.textile.client.me.ui.fragment.MeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {


    override fun startLoad() {
    }

    override fun initView() {
        setFullScreen()

        navigation.onNavigationItemSelectedListener = mOnNavigationItemSelectedListener
        navigation.enableAnimation(false)
        navigation.enableShiftingMode(false)

        changeOrNewFragment(getString(R.string.frag_mall))

        fab_add.setOnClickListener { changeOrNewFragment(getString(R.string.frag_add)) }
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
                "add" -> MallFragment.newInstance()
                "shop_car" -> MallFragment.newInstance()
                "me" -> MeFragment.newInstance()
                else -> MallFragment.newInstance()
            }
        }
        transaction.replace(R.id.fragment, fragment!!, tag)
        transaction.commit()
    }
}
