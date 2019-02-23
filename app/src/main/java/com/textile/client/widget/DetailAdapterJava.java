package com.textile.client.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.game.base.image.ImageUtil;
import com.textile.client.R;

import java.util.ArrayList;

public class DetailAdapterJava extends PagerAdapter {
    private ArrayList<String> data;
    private JzvdStd mVideo;

    public DetailAdapterJava(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View view = getViewByUrl(container.getContext(), data.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public View getViewByUrl(Context context, String url) {
        View view;
        if (url.endsWith("mp4")) {
            view = LayoutInflater.from(context).inflate(R.layout.item_detail_video, null, false);
            mVideo = view.findViewById(R.id.mVideoPlayer);
            mVideo.setUp(url, "", Jzvd.SCREEN_WINDOW_NORMAL);
            ImageUtil.INSTANCE.displayImage(context, mVideo.thumbImageView, url, R.drawable.default_header);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_detail_page, null, false);
            ImageView imageView = view.findViewById(R.id.mItemDetailIv);
            ImageUtil.INSTANCE.displayImage(context, imageView, url, R.drawable.default_header);
        }
        return view;
    }

    public void setVideoRelease() {
        if (mVideo != null) {
            mVideo.releaseAllVideos();
        }
    }

    public void setVideoPause() {
        if (mVideo != null) {
            mVideo.onStatePause();
        }
    }

    public void setVideoPlay() {
        if (mVideo != null) {
            mVideo.onStatePlaying();
        }
    }
}
