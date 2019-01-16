package com.game.base.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.game.base.wdget.LoadingDialog

/**
 * Created by lff on 2018/12/19.
 */
abstract class BaseFragment : Fragment(), IBaseView {
    private lateinit var mLoadingDialog: LoadingDialog
    var isViewPrepare = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), null)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadData()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView(view)
        lazyLoadData()
    }

    abstract fun initView(view: View)

    abstract fun lazyLoadData()

    abstract fun getLayoutId(): Int

    override fun showLoading() {
        mLoadingDialog = LoadingDialog(activity!!)
        mLoadingDialog.show()
    }

    override fun dismissLoading() {
        mLoadingDialog.takeIf { it.isShowing }?.dismiss()
    }

    override fun getContext(): BaseActivity {
        return this.activity!! as BaseActivity
    }
}