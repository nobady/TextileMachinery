package com.textile.client.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.textile.client.R
import kotlinx.android.synthetic.main.detail_top_view.view.*

class DetailTopView : FrameLayout, ViewPager.OnPageChangeListener {
    private lateinit var mAdapter: DetailAdapterJava
    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        mPagerNumberView.setCurrentPage(position + 1)
//        if (position == 0) {
//            mAdapter.setVideoPlay()
//        } else {
//            mAdapter.setVideoPause()
//        }
    }

    private lateinit var data: ArrayList<String>

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.detail_top_view, this, true)
        mDetailTopVp.addOnPageChangeListener(this)
    }

    fun setUrls(urls: ArrayList<String>) {
        data = urls
        mPagerNumberView.setTotalPage(data.size)
        mAdapter = DetailAdapterJava(urls)
        mDetailTopVp.adapter = mAdapter
        mDetailTopVp.setOffscreenPageLimit(data.size / 2)
    }

}