package com.example.android.apis.deivces;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.apis.R;

public class GpsMockActivity extends ActionBarActivity {

    private String mMockProviderName = "ray";
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_mock);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.getProvider(mMockProviderName) == null) {
            locationManager.addTestProvider(mMockProviderName, false, true, false, false, false, false, false, 0, 5);
            locationManager.setTestProviderEnabled(mMockProviderName, true);
        }

        findViewById(R.id.caculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double longitude = Double.parseDouble(((TextView) findViewById(R.id.longitude)).getText().toString());
                Double latitude = Double.parseDouble(((TextView) findViewById(R.id.latitude)).getText().toString());
                createLocation(latitude, longitude);
            }
        });
    }

    public Location createLocation(Double latitude, Double longitude) {
        Location loc = new Location(mMockProviderName);
        loc.setTime(System.currentTimeMillis());
        loc.setLatitude(latitude);
        loc.setLongitude(longitude);
        locationManager.setTestProviderLocation(mMockProviderName, loc);
        return loc;
    }
}
