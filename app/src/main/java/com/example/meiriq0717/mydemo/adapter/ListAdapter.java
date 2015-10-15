package com.example.meiriq0717.mydemo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.srain.cube.views.list.ListViewDataAdapterBase;

/**
 * Created by meiriq0717 on 2015/10/15.
 */
public class ListAdapter extends ListViewDataAdapterBase {
    private List<Map<String, String>> mList = new ArrayList<Map<String, String>>();

    public void setmList(List<Map<String, String>> list) {
        mList = list;
    }
    
    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }
}
