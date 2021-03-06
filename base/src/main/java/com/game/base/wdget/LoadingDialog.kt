package com.game.base.wdget

import android.app.Dialog
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.widget.ProgressBar
import com.game.base.R
import com.github.ybq.android.spinkit.style.FadingCircle

/**
 * @author ex-yangjb001
 * @date 2019/1/10.
 */
class LoadingDialog(activity: Context) : Dialog(activity, R.style.LoadingDialog) {
    init {
        val view = LayoutInflater.from(activity).inflate(R.layout.loading, null, false)
        setContentView(view)
        setCanceledOnTouchOutside(false)
        val mLoadingPb = view.findViewById<ProgressBar>(R.id.mLoadingPb)
        val bounce = FadingCircle()
        bounce.setBounds(0, 0, 100, 100)
        bounce.color = R.color.mainTextColor
        mLoadingPb.indeterminateDrawable = bounce
    }
}