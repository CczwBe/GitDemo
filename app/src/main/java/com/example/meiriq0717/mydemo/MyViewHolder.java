package com.example.meiriq0717.mydemo;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

import in.srain.cube.image.CubeImageView;
import in.srain.cube.image.ImageLoader;
import in.srain.cube.views.list.ViewHolderBase;

/**
 * Created by meiriq0717 on 2015/10/15.
 */
public class MyViewHolder extends ViewHolderBase<Map<String, String>> {
    private CubeImageView cubeIv;
    private TextView imageTitle;
    private ImageLoader mImageLoader;

    public MyViewHolder(ImageLoader imageLoader) {
        mImageLoader = imageLoader;
    }

    @Override
    public View createView(LayoutInflater layoutInflater) {
        View view = layoutInflater.inflate(R.layout.item_layout, null);
        cubeIv = (CubeImageView) view.findViewById(R.id.cube_iv);
        imageTitle = (TextView) view.findViewById(R.id.imageTitle);

        return view;
    }

    @Override
    public void showData(int i, Map<String, String> map) {
        cubeIv.loadImage(mImageLoader, map.get("imageUrl"));
        imageTitle.setText(map.get("title"));

    }

}
