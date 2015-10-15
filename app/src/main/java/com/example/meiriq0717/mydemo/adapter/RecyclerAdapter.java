package com.example.meiriq0717.mydemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meiriq0717.mydemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.srain.cube.image.CubeImageView;
import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.image.impl.DefaultImageLoadHandler;

/**
 * Created by meiriq0717 on 2015/10/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ImageLoader mImageLoader;
    private List<Map<String, String>> mList = new ArrayList<Map<String, String>>();
    private Context mContext;

    public RecyclerAdapter(Context context) {
        mContext = context;
        DefaultImageLoadHandler imageLoadHandler = new DefaultImageLoadHandler(mContext);
        imageLoadHandler.setImageRounded(true, 50);
        imageLoadHandler.setLoadingImageColor(Color.CYAN);
        mImageLoader = ImageLoaderFactory.create(mContext, imageLoadHandler);

    }

    public void setmList(List<Map<String, String>> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.imageTitle.setText(mList.get(i).get("title"));
        viewHolder.cube_iv.loadImage(mImageLoader, mList.get(i).get("imageUrl"));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CubeImageView cube_iv;
        private TextView imageTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            cube_iv = (CubeImageView) itemView.findViewById(R.id.cube_iv);
            imageTitle = (TextView) itemView.findViewById(R.id.imageTitle);
        }
    }
}
