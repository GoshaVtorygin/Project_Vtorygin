package com.example.admin_pc.project_vtorygin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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

import static com.example.admin_pc.project_vtorygin.TypefaceUtil.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overrideFont(getApplicationContext(), "SERIF", "font/lobster.ttf");
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
    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(59.950115, 30.316371))
                .zoom(13)
                .bearing(0)
                .tilt(0)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.animateCamera(cameraUpdate);

        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.935361, 30.347850))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("union",100,100)))
                .title("бар Union"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.929976, 30.327834))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("aprashka",100,87)))
                .title("Апраксин двор"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.924797, 30.295925))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("theater",100,100)))
                .title("Мариинский театр"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.941955, 30.305922))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("kunstkamera",100,50)))
                .title("Кунсткамера"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.938277, 30.314915))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("square",100,69)))
                .title("Эрмитаж"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.949179, 30.311993))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("fortress",100,69)))
                .title("Петропавловская крепость"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.934036, 30.325602))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cathedral",100,65)))
                .title("Казанский собор"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.968455, 30.330646))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("garden",100,100)))
                .title("Ботанический сад"));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(59.936904, 30.303517))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("horseman",100,68)))
                .title("Медный всадник"));
    }
}
