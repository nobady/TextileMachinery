package com.textile.client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.game.base.image.ImageUtil
import kotlinx.android.synthetic.main.activity_show_big_image.*

class ShowBigImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_big_image)
        val url = intent.getStringExtra("image_url")
        ImageUtil.displayImage(this, mPhotoView, url, R.drawable.default_header)
    }
}
