package com.example.lakwatsaph;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

public class maps extends FragmentActivity implements OnMapReadyCallback{
    GoogleMap map;
    Button btngetBack, btngetDir;
    MarkerOptions loc1, loc2;
    Polyline polyline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapdemo);
        btngetDir = findViewById(R.id.getDir);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getBack();
    }

    @Override
    public void onMapReady( GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        map.setTrafficEnabled(true);
        map.setMinZoomPreference(15.0f);
        LatLng minesviewpark = new LatLng(16.42329952159431, 120.63078680384233);
        map.addMarker(new MarkerOptions().position(minesviewpark).title("Mines View Park"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(minesviewpark,13));
    }

    private void getBack(){
        btngetBack = findViewById(R.id.getBackbtn);

        btngetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng minesviewpark = new LatLng(16.42329952159431, 120.63078680384233);
                map.addMarker(new MarkerOptions().position(minesviewpark).title("Mines View Park"));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(minesviewpark,10));
            }
        });
    }
}
