package com.example.thodlydugue.kizinlakayapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jerry on 8/22/2017.
 */

public class RecetteArrayAdapter extends ArrayAdapter<Recette> {
    ListView lvrecette;
    int selectposition = -1;


    public RecetteArrayAdapter(Context context, List<Recette> articles){
        super(context, android.R.layout.simple_list_item_1, articles);
    }

    private ImageButton bthome;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Recette recette = this.getItem(position);

        if (convertView == null){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.search_recette_result, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);

        imageView.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvRecette);

        // tvTitle.setText(recette.getHeadLine());

        // String thumbnail = recette.getThumbNail();

       /* if(!TextUtils.isEmpty(thumbnail)){
            Picasso.with(getContext()).load(thumbnail).into(imageView);
        }*/
        return convertView;
    }


}
