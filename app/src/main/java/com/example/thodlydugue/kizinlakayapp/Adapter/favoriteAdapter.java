package com.example.thodlydugue.kizinlakayapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thodlydugue.kizinlakayapp.Modele.favorites;
import com.example.thodlydugue.kizinlakayapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sonel on 9/11/2017.
 */

public class favoriteAdapter   extends ArrayAdapter<favorites>

{


        // View lookup cache
        private static class ViewHolder {
            TextView textrecette;
            ImageView imageView;
            TextView txtdesc;
        }
    public favoriteAdapter(Context context, ArrayList<favorites> users) {
        super(context, R.layout.recette_favorie, users);

    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        favorites fav = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        favoriteAdapter.ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new favoriteAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.recette_favorie, parent, false);
            viewHolder.textrecette = (TextView) convertView.findViewById(R.id.txtrecettefav);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imrecettefav);
           // viewHolder.txtdesc=(TextView) convertView.findViewById(R.id.txtdescription);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (favoriteAdapter.ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.

        viewHolder.textrecette.setText(fav.getNom_recette());
        Picasso.with(getContext()).load(fav.getImage_recette()).resize(240, 120).into(viewHolder.imageView);
        //viewHolder.txtdesc.setText(r.getDescription());

        // viewHolder.home.setText(user.hometown);
        // Return the completed view to render on screen.
        //viewHolder.textrecette.setText(recettes.fromListMap()+);
        return convertView;
    }

    }
