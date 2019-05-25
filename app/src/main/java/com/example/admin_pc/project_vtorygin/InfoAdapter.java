package com.example.admin_pc.project_vtorygin;


import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.HashMap;



public class InfoAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity context;

    public InfoAdapter(Activity context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = context.getLayoutInflater().inflate(R.layout.info, null);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/lobster.ttf");
        HashMap<String, Integer> hashMapInfo = new HashMap<String,Integer>();
        hashMapInfo.put(context.getString(R.string.aprashka_title), R.drawable.aprashka_im);
        hashMapInfo.put(context.getString(R.string.fortress_title), R.drawable.fortress_im);
        hashMapInfo.put(context.getString(R.string.garden_title), R.drawable.garden_im);
        hashMapInfo.put(context.getString(R.string.kunstkamera_title), R.drawable.kunstkamera_im);
        hashMapInfo.put(context.getString(R.string.square_title), R.drawable.square_im);
        hashMapInfo.put(context.getString(R.string.theater_title), R.drawable.theater_im);
        hashMapInfo.put(context.getString(R.string.union_title), R.drawable.union_im);

        TextView title = view.findViewById(R.id.title);
        TextView text = view.findViewById(R.id.text);
        ImageView sight = view.findViewById(R.id.sight);
        title.setTypeface(type);
        text.setTypeface(type);
        title.setText(marker.getTitle());
        text.setText(marker.getSnippet());
        sight.setImageResource(hashMapInfo.get(marker.getTitle()));
        return view;
    }
}


