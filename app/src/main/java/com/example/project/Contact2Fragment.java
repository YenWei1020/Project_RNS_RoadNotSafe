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
import android.support.v4.app.FragmentTransaction;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Scanner;

/**
 * A simple {@link Fragment} subclass.
 */

public class Contact2Fragment extends Fragment implements OnMapReadyCallback
{
    public  GoogleMap mMap;
    public RadioGroup radioGroup;
    public  RadioButton radioButton;
    public double lat,lon  ;
    public int a=20;

    public Contact2Fragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(23.558581, 120.471984), 15));// 移動鏡頭,zoom放大地圖

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
       mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
       {
            @Override
            public void onMapClick(LatLng point)
            {

                AlertDialog.Builder builder;
                AlertDialog alertDialog;
                Context mContext = Contact2Fragment.this.getContext();
                LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = vi.inflate(R.layout.alertdialog, null);
                RadioGroup rg = (RadioGroup)view.findViewById(R.id.RadioGroup);
                lat = point.latitude;
                lon = point.longitude;
                final EditText editText = (EditText) view.findViewById(R.id.input);

                builder = new AlertDialog.Builder(mContext);
                builder.setView(view);
                String m_Text = editText.getText().toString();
                final MarkerOptions marker = new MarkerOptions().position(new LatLng(lat,lon)).title("未說明").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId){
                            case R.id.radioButton_Green:
                                group.check(R.id.radioButton_Green);
                                marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                                break;
                            case R.id.radioButton_Yellow:
                                group.check(R.id.radioButton_Yellow);
                                marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)) ;
                                break;
                            case R.id.radioButton_Red:
                                group.check(R.id.radioButton_Red);
                                marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)) ;
                                break;
                        }
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Contact2Fragment.this.getContext(),"取消",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Context mContext = Contact2Fragment.this.getContext();
                        LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View view = vi.inflate(R.layout.alertdialog, null);
                        RadioGroup rg = (RadioGroup)view.findViewById(R.id.RadioGroup);
                        String m_Text = editText.getText().toString();

                        if(m_Text.isEmpty())
                            marker.title("未說明");
                        else
                            marker.title(m_Text);

                        mMap.addMarker(marker);
                        Toast.makeText(Contact2Fragment.this.getContext(),"新增完成",Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                });
                alertDialog = builder.create();
                alertDialog.setTitle("Describe the situation");
                alertDialog.show();
            }
      });
       //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }
}
