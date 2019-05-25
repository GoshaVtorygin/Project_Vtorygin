package com.example.admin_pc.project_vtorygin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        MarkerOptions markerOpt = new MarkerOptions();
        InfoAdapter adapter = new InfoAdapter(MapsActivity.this);
        map.setInfoWindowAdapter(adapter);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(59.939658, 30.322585))
                .zoom(13)
                .bearing(0)
                .tilt(0)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.animateCamera(cameraUpdate);

        markerOpt.position(new LatLng(59.928112, 30.330234))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("aprashka",80,80)))
                .title(getString(R.string.aprashka_title))
                .snippet(getString(R.string.aprashka_text));
        map.addMarker(markerOpt);
        markerOpt.position(new LatLng(59.949913, 30.312890))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("fortress",80,80)))
                .title(getString(R.string.fortress_title))
                .snippet(getString(R.string.fortress_text));
        map.addMarker(markerOpt);
        markerOpt.position(new LatLng(59.969756, 30.327196))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("garden",80,80)))
                .title(getString(R.string.garden_title))
                .snippet(getString(R.string.garden_text));
        map.addMarker(markerOpt);
        markerOpt.position(new LatLng(59.941960, 30.305119))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("kunstkamera",80,80)))
                .title(getString(R.string.kunstkamera_title))
                .snippet(getString(R.string.kunstkamera_text));
        map.addMarker(markerOpt);
        markerOpt.position(new LatLng(59.939646, 30.316206))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("square",80,80)))
                .title(getString(R.string.square_title))
                .snippet(getString(R.string.square_text));
        map.addMarker(markerOpt);
        markerOpt.position(new LatLng(59.925222, 30.296075))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("theater",80,80)))
                .title(getString(R.string.theater_title))
                .snippet(getString(R.string.theater_text));
        map.addMarker(markerOpt);
        markerOpt.position(new LatLng(59.935361, 30.347850))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("union",80,80)))
                .title(getString(R.string.union_title))
                .snippet(getString(R.string.union_text));
        map.addMarker(markerOpt);
    }

    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

}
