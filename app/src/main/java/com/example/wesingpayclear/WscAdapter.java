package com.example.wesingpayclear;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WscAdapter extends ArrayAdapter<Wsc> {
    private int resourceId;

    public WscAdapter(Context context, int textViewResourceId, List<Wsc> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Wsc wsc=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView wsc_image=(ImageView)view.findViewById(R.id.image_view);
        TextView wsc_textview=(TextView)view.findViewById(R.id.text_view);
        wsc_image.setImageResource(Wsc.getWscImageId());
        wsc_textview.setText(Wsc.getWscTextView());
        return view;
    }
}
