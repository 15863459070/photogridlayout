package cn.ljp.photogridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) ;
        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setNestedScrollingEnabled(false);
        List<ItemBean> lists = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            lists.add(new ItemBean(i + 1));
        }
        ItemAdapter itemAdapter = new ItemAdapter(this, lists);
        recyclerView.setAdapter(itemAdapter);
    }
}
