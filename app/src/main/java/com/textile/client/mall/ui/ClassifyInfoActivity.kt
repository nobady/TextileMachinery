package com.textile.client.mall.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.game.base.mvp.BaseActivity
import com.textile.client.R
import kotlinx.android.synthetic.main.activity_classify_info.*

class ClassifyInfoActivity : BaseActivity() {

    private lateinit var titleName:String
    private lateinit var classifyId:String

    override fun startLoad() {
    }

    override fun initView() {
        initTitle()
    }

    private fun initTitle() {
        titleName = intent.getStringExtra("title")
        classifyId = intent.getStringExtra("id")
        classifyHeadView.setTitle(titleName)
        classifyHeadView.showBack()
    }

    override fun initData() {
    }

    override fun layoutId() = R.layout.activity_classify_info

}
