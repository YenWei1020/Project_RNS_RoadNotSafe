package com.example.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.Scanner;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.maps.GoogleMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact3Fragment extends Fragment  implements OnMapReadyCallback{

    public GoogleMap mMap;
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    public double lat,lon  ;

    public Contact3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact_map, container, false);

        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.addMarker(new MarkerOptions().position(new LatLng(23.558581, 120.471984))
                .title("施工")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(23.554112, 120.471760))
                .title("施工")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(23.555232, 120.471720))
                .title("施工")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(23.556255, 120.471698))
                .title("施工")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(23.560212, 120.445500))
                .title("道路顛簸")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.getUiSettings().setCompassEnabled(true);       // 左上角的指南針，要兩指旋轉才會出現

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom( new LatLng(23.558581, 120.471984), 15));// 移動鏡頭,zoom放大地圖


        //↓↓↓↓↓↓↓↓點擊刪除事件↓↓↓↓↓↓↓↓

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(final Marker marker) {
                AlertDialog.Builder builder;
                AlertDialog alertDialog;
                Context mContext = Contact3Fragment.this.getContext();


                builder = new AlertDialog.Builder(mContext);


                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Contact3Fragment.this.getContext(),"取消",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        marker.remove();
                        Toast.makeText(Contact3Fragment.this.getContext(),"移除成功",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                });
                builder.setMessage(marker.getTitle());
                alertDialog = builder.create();
                alertDialog.setTitle("確定要刪除嗎?");

                alertDialog.show();
                return false;
            }

        });
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }

}
