package com.example.meiriq0717.mydemo;

import android.app.Application;
import android.graphics.Color;
import android.os.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.srain.cube.Cube;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.image.impl.DefaultImageLoadHandler;
import in.srain.cube.util.LocalDisplay;

/**
 * Created by meiriq0717 on 2015/10/15.
 */
public class MyApplication extends Application {
    MyApplication instance;
    private static List<Map<String, String>> mList = new ArrayList<Map<String, String>>();

    public  List<Map<String, String>> getmList() {
        return mList;
    }

    public void setmList(List<Map<String, String>> list) {
        mList = list;
    }

    @Override
    public void onCreate() {
        if (instance == null) {
            instance = this;
        }
        Cube.onCreate(instance);
        initImageLoader();
        super.onCreate();
    }

    public void initImageLoader() {
        DefaultImageLoadHandler handler = new DefaultImageLoadHandler(this);
        handler.setImageRounded(true, LocalDisplay.dp2px(50));
        handler.setLoadingImageColor(Color.parseColor("#3fffff"));
        handler.setImageFadeIn(true);
        handler.setLoadingResources(R.mipmap.ic_launcher);
        ImageLoaderFactory.setDefaultImageLoadHandler(handler);
        ImageLoaderFactory.customizeCache(this, 10 * 1024, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath(), 10 * 1024);
    }
}
