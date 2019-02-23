package com.textile.client.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.textile.client.R
import kotlinx.android.synthetic.main.pager_num_view.view.*

class PagerNumberView : LinearLayout {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.pager_num_view, this, true)
    }

    fun setTotalPage(total: Int) {
        mTotalPage.text = total.toString()
    }

    fun setCurrentPage(current: Int) {
        mCurrentPage.text = current.toString()
    }
}