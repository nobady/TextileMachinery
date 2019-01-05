package com.game.base.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by lff on 2018/12/19.
 */
abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
        startLoad()
    }

    /*加载数据*/
    abstract fun startLoad()
    /*初始化view*/
    abstract fun initView()
    /*初始化数据*/
    abstract fun initData()
    /*布局id*/
    abstract fun layoutId(): Int
}