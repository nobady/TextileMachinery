package com.yang.mac.memodule.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yang.mac.memodule.R
import kotlinx.android.synthetic.main.activity_my_pay_type.*

class MyPayTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_pay_type)
        mPayHeadView.setTitle(getString(R.string.pay_type))
        mPayHeadView.showBack()
    }
}
