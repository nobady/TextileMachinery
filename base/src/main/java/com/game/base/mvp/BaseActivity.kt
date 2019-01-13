package com.game.base.mvp

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.game.base.wdget.LoadingDialog

/**
 * Created by lff on 2018/12/19.
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView {
    private lateinit var mLoadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
        startLoad()
    }

     fun setStatusBarColor(colorRes: Int) {
        if (Build.VERSION.SDK_INT >= 21) {
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
        mLoadingDialog = LoadingDialog(this)
        mLoadingDialog.show()
    }

    override fun dismissLoading() {
        mLoadingDialog.takeIf { it.isShowing }?.dismiss()
    }

    override fun getContext(): Context {
        return this
    }
}