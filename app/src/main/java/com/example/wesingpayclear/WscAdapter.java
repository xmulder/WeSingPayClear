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
        ViewHolder viewHolder;
        View viewt = null;
        if(convertView==null){
            viewt= LayoutInflater.from(getContext()).inflate(resourceId,null,false);
            viewHolder=new ViewHolder();
            viewHolder.wsc_image=(ImageView)viewt.findViewById(R.id.image_view);
            viewHolder.wsc_textview=(TextView)viewt.findViewById(R.id.text_view);
            viewt.setTag(viewHolder);
        }else{
            viewt=convertView;
            viewHolder=(ViewHolder)viewt.getTag();
        }
        viewHolder.wsc_image.setImageResource(Wsc.getWscImageId());
        viewHolder.wsc_textview.setText(Wsc.getWscTextView());
        //ImageView wsc_image= (ImageView)viewt.findViewById(R.id.image_view);
        //TextView wsc_textview=(TextView) viewt.findViewById(R.id.text_view);
        //wsc_image.setImageResource(Wsc.getWscImageId());
        //wsc_textview.setText(Wsc.getWscTextView());
        return viewt;
    }

    class ViewHolder{
        ImageView wsc_image;
        TextView wsc_textview;
    }


}
