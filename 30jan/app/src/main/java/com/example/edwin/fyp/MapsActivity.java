package com.example.edwin.fyp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    //DatabaseReference mDepartureRef;//= mRootRef.child("condition");
    String personName,personGivenName,personFamilyName,personEmail,personId;
    Uri personPhoto;
    //double hy_lat,hy_long,l_lat,l_long;
    String hy_lat_text,hy_long_text;
    DatabaseReference mHenYeeRef,mlawrenceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

/*
        mHenYeeRef= mRootRef.child("drivers/103466554388941262490/latitude");
        mHenYeeRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hy_lat_text = dataSnapshot.getValue(String.class);
                //hy_lat_text = Double.parseDouble(text);
                //mDeparture.setText(getString(R.string.departure_view,text));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


        mHenYeeRef= mRootRef.child("drivers/103466554388941262490/longitude");
        mHenYeeRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hy_long_text = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
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

        LatLng C1 = new LatLng(3.0061, 101.7199);

        mMap.addMarker(new MarkerOptions()
                .title("C1")
                .position(C1).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C1, zoomLevel));
/*
        LatLng C2 = new LatLng(3.0061, 101.7199);
        mMap.addMarker(new MarkerOptions()
                .title("C2")
                .position(C2).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C2, zoomLevel));
*/
        LatLng C3 = new LatLng(2.999652, 101.708264);
        mMap.addMarker(new MarkerOptions()
                .title("C3")
                .position(C3).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C3, zoomLevel));

        LatLng C4 = new LatLng(3.0102375, 101.7202033);
        mMap.addMarker(new MarkerOptions()
                .title("C4")
                .position(C4).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(C4, zoomLevel));

        //hy_lat=0.00;hy_long=0.00;
        double hy_lat = 6.4363725;//Double.valueOf(hy_lat_text);
        //hy_lat = double.
        double hy_long = 100.301762;//Double.valueOf(hy_long_text);
        LatLng HY = new LatLng(hy_lat, hy_long);
        mMap.addMarker(new MarkerOptions()
                .title("HY")
                .position(HY).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HY, zoomLevel));

        double lw_lat = 3.0850438;//Double.valueOf(hy_lat_text);
        //hy_lat = double.
        double lw_long = 101.4205813;//Double.valueOf(hy_long_text);
        LatLng lw = new LatLng(lw_lat, lw_long);
        mMap.addMarker(new MarkerOptions()
                .title("lw")
                .position(lw).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lw, zoomLevel));

        double l_lat = 1.8063137;//Double.valueOf(hy_lat_text);
        //hy_lat = double.
        double l_long = 103.4871619;//Double.valueOf(hy_long_text);
        LatLng lawrence = new LatLng(l_lat, l_long);
        mMap.addMarker(new MarkerOptions()
                .title("lawrence")
                .position(lawrence).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mycoms",75,75))));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lawrence, zoomLevel));

    }



    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}
