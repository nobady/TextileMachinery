package com.textile.client.home.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.game.base.mvp.BaseFragment
import com.textile.client.R
import com.textile.client.mall.ui.MallFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private  var currentFragment: Fragment? = null

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.onNavigationItemSelectedListener = mOnNavigationItemSelectedListener
        navigation.enableAnimation(false)
        navigation.enableShiftingMode(false)

        changeOrNewFragment(getString(R.string.frag_mall))

        fab_add.setOnClickListener {   changeOrNewFragment(getString(R.string.frag_add)) }
    }

    private fun changeOrNewFragment(tag:String){
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        val transaction = supportFragmentManager.beginTransaction()

        fragment?:let {
            fragment = when(tag){
                "mall"-> MallFragment.newInstance()
                "forum"-> MallFragment.newInstance()
                "add"-> MallFragment.newInstance()
                "shop_car"-> MallFragment.newInstance()
                "me"-> MallFragment.newInstance()
                else -> MallFragment.newInstance()
            }
        }
        transaction.replace(R.id.fragment,fragment!!,tag)
        transaction.commit()
    }
}
