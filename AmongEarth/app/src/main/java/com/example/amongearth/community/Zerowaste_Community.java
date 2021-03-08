package com.example.amongearth.community;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.amongearth.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Zerowaste_Community extends AppCompatActivity {
    ArrayList<Community_Page1_List2> zero_waste_list;
    ListView zero_waste_board;
    private Context mContext;
    Drawable[] icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community_zerowaste_main);

        mContext = this.getApplicationContext();
        zero_waste_board = (ListView) findViewById(R.id.zero_waste_list);
        icon = new Drawable[]{this.getResources().getDrawable(R.drawable.person1), this.getResources().getDrawable(R.drawable.person2), this.getResources().getDrawable(R.drawable.person3)};
        this.InitializeZeroData();
        final ListViewAdapter2 listViewAdapter2 = new ListViewAdapter2(this, zero_waste_list);
        zero_waste_board.setAdapter(listViewAdapter2);

    }

    private void InitializeZeroData(){
        zero_waste_list = new ArrayList<>();
        // 클릭하면 변화하는 것 도 만들어야함 // 하트도 만들어야 함
        Intent intent = getIntent();
        HashMap<Integer, ArrayList<ArrayList<String>>> hashmap = (HashMap<Integer, ArrayList<ArrayList<String>>>) intent.getSerializableExtra("hashmap");

        TreeMap<Integer, ArrayList<ArrayList<String>>> treeMap = new TreeMap<>(hashmap);
        Iterator<Integer> iterator = treeMap.keySet().iterator();

        Integer key;
        ArrayList<ArrayList<String>> value;

        while(iterator.hasNext()){
            key = Integer.parseInt(iterator.next()+"");
            value = treeMap.get(key);
            for (int i=0; i<value.size(); i++){
                zero_waste_list.add(new Community_Page1_List2( icon[Integer.parseInt(value.get(i).get(5))-1], value.get(i).get(4),
                        value.get(i).get(0), value.get(i).get(1),value.get(i).get(2),value.get(i).get(3), value.get(i).get(6), value.get(i).get(7)));
            }
        }
        //zero_waste_list.add(new Community_Page1_List2( this.getResources().getDrawable(R.drawable.person1), this.getResources().getDrawable(R.drawable.photo1),ni, da,co,linu));


    }

}
