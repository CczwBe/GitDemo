package com.example.meiriq0717.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.meiriq0717.mydemo.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recview);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter(MainActivity.this);
        initData();
        adapter.setmList(list);
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        for (int i = 0; i < Images.imageUrls.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("title", "imageTitle" + i);
            map.put("imageUrl", Images.imageUrls[i]);
            list.add(map);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
