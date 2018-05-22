package com.example.edwin.fyp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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
        float zoomLevel = 16.0f;
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        LatLng C1 = new LatLng(3.0061, 101.7199);
        //mMap.addMarker(new MarkerOptions().position(C1).title("C1"));
        mMap.addMarker(new MarkerOptions()
                .title("C1")
                //.snippet("Check out this place.")
                .position(C1).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C1, zoomLevel));

        LatLng C2 = new LatLng(3.0061, 101.7199);
        //mMap.addMarker(new MarkerOptions().position(C2).title("C2"));
        mMap.addMarker(new MarkerOptions()
                .title("C2")
                //.snippet("Check out this place.")
                .position(C2).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C2, zoomLevel));

        LatLng C3 = new LatLng(2.999652, 101.708264);
        //mMap.addMarker(new MarkerOptions().position(C3).title("C3"));
        mMap.addMarker(new MarkerOptions()
                .title("C3")
                //.snippet("Check out this place.")
                .position(C3).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C3, zoomLevel));

        LatLng C4 = new LatLng(3.0102375, 101.7202033);
        ////MarkerOptions marker = new MarkerOptions().position(C4).title("C4");
        //marker.icon(BitmapDescriptorFactory.fromBitmap(R.drawable.mycoms));
        mMap.addMarker(new MarkerOptions()
                .title("C4")
                //.snippet("Check out this place.")
                .position(C4).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C4, zoomLevel));
    }

    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}
