package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

    private Context mContext;
    private View mWindow;
    private Button button_report;



    public CustomInfoWindowAdapter(Context context) {

        this.mContext =context;
        this.mWindow=LayoutInflater.from(context).inflate(R.layout.custom_info_window,null);

    }
    private void rendowWindowText(Marker marker,View view)
    {
        String title = marker.getTitle();
        TextView tvTitle = (TextView)view.findViewById(R.id.tv_title);

        tvTitle.setText(title);
    }
    @Override
    public View getInfoWindow(Marker marker) {
        rendowWindowText(marker,mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendowWindowText(marker,mWindow);
        return mWindow;
    }

}
