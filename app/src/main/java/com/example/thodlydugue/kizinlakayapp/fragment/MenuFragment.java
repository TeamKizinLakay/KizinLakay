package com.example.thodlydugue.kizinlakayapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.thodlydugue.kizinlakayapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sonel on 8/18/2017.
 */

public class MenuFragment extends Fragment {


    // Array of integers points to images stored in /res/drawable/
    int[] menus = new int[]{
            R.drawable.meats_menu,
            R.drawable.meats_menu,
            R.drawable.meats_menu,
            R.drawable.meats_menu

    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<4;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("ivmenu", Integer.toString(menus[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "ivmenu" };

        // Ids of views in listview_layout
        int[] to = { R.id.ivmenu};

        View v = inflater.inflate(R.layout.layoutview_menu, container,false);
        ListView list = (ListView)v.findViewById(R.id.idlist);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.itemimage_menu, from, to);
        list.setAdapter(adapter);
        return v;
    }

}
