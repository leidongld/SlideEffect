package com.example.leidong.slideeffect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyListView.RemoveListener{
    private MyListView myListView;
    private ArrayAdapter<String> adapter;
    private List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        myListView = (MyListView) findViewById(R.id.myListView);
        myListView.setRemoveListener(this);

        for(int i = 0; i < 20; i++){
            datas.add("滑动删除  " + i);
        }

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.list_item, datas);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, datas.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 滑动删除条目
     * @param direction
     * @param position
     */
    @Override
    public void removeItem(MyListView.RemoveDirection direction, int position) {
        adapter.remove(adapter.getItem(position));
        switch (direction){
            case RIGHT:
                Toast.makeText(MainActivity.this, "向右删除", Toast.LENGTH_SHORT).show();
                break;
            case LEFT:
                Toast.makeText(MainActivity.this, "向左删除", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
