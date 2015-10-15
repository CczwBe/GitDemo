package com.example.meiriq0717.mydemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridView;

import com.example.meiriq0717.mydemo.adapter.ListAdapter;

import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.image.impl.DefaultImageLoadHandler;
import in.srain.cube.util.LocalDisplay;

/**
 * Created by meiriq0717 on 2015/10/15.
 */
public class SecondActivity extends Activity {
    private GridView gr_view;
    private ListAdapter adapter;
    private ImageLoader mImageLoader;
    private DefaultImageLoadHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity_layout);
        initView();
    }

    private void initView() {
        gr_view = (GridView) findViewById(R.id.gr_view);
        adapter = new ListAdapter();
        handler = new DefaultImageLoadHandler(this);
        handler.setImageRounded(true, LocalDisplay.dp2px(50));
        handler.setImageFadeIn(true);
        handler.setLoadingImageColor(Color.BLUE);
        mImageLoader = ImageLoaderFactory.create(this, handler);
        adapter.setViewHolderClass(this, MyViewHolder.class, mImageLoader);
        adapter.setmList(new MyApplication().getmList());
        adapter.notifyDataSetChanged();
        gr_view.setAdapter(adapter);

    }
}
