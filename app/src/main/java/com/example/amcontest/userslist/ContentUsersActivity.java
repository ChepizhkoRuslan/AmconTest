package com.example.amcontest.userslist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import com.example.amcontest.R;
import com.example.amcontest.data.model.ListUsersResponse;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentUsersActivity extends FragmentActivity implements OnMapReadyCallback {
    @BindView(R.id.user_content)
    TextView tvContent;

    private static ListUsersResponse contentUsers;
    private GoogleMap mMap;
    private double lat = 0.0, lon = 0.0;


    @Inject
    public ContentUsersActivity() {
    }

    public static Intent newInstance(Context context, ListUsersResponse contentUser) {
        contentUsers = contentUser;
        return new Intent(context, ContentUsersActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_place);
        ButterKnife.bind(this);

        lat = Double.parseDouble(contentUsers.getAddress().getGeo().getLat());
        lon = Double.parseDouble(contentUsers.getAddress().getGeo().getLng());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapViewInfo_new_place);
        mapFragment.getMapAsync(this);
        tvContent.setText(contentUsers.toString());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(lat,lon);
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.addMarker(new MarkerOptions().position(latLng).title("User"));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.animateCamera(cameraUpdate);
    }
}
