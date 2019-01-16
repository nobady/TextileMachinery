package com.textile.client.mall.ui.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bigkoo.convenientbanner.holder.Holder
import com.game.base.image.ImageUtil
import com.textile.client.R
import com.textile.client.mall.model.BannerModel

/**
 * Created by lff on 2019/1/14.
 */
class BannerImageHolder: Holder<BannerModel.ListData> {

    private var imageView:ImageView? = null

    override fun UpdateUI(context: Context?, position: Int, data: BannerModel.ListData?) {
        ImageUtil.displayImage(context!!,imageView!!,data!!.image, R.mipmap.default_banner)
    }

    override fun createView(context: Context?): View? {
        imageView = ImageView(context)
        imageView?.scaleType = ImageView.ScaleType.FIT_XY
        return imageView
    }
}