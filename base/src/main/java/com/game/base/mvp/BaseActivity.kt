package com.game.base.mvp

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

/**
 * Created by lff on 2018/12/19.
 */
abstract class BaseActivity:AppCompatActivity(),IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
        startLoad()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public fun setStatusBarColor(colorRes:Int){
        takeIf { Build.VERSION.SDK_INT>=21 }.apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = colorRes
        }
    }

    /*加载数据*/
    abstract fun startLoad()
    /*初始化view*/
    abstract fun initView()
    /*初始化数据*/
    abstract fun initData()
    /*布局id*/
    abstract fun layoutId(): Int

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }
}