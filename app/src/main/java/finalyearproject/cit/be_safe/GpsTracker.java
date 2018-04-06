package finalyearproject.cit.be_safe;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

/**
 * Created by Rahul on 4/21/2016.
 */
public class GpsTracker extends Service implements LocationListener{
    private final Context context;
    boolean isGpsEnabled=false;
    boolean isNetworkenaled=false;
    boolean cangetLocation=false;
    Location location;
    double latitude;
    double longitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES=10;
    private static final long MIN_TIME_BW_UPDATES=1000*60*1;
    protected LocationManager locationManager;
    public GpsTracker(Context context){
        this.context=context;
        getLocation();
    }
    public Location getLocation(){
        try{
            locationManager=(LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGpsEnabled=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkenaled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if(!isGpsEnabled&&!isNetworkenaled){

            }else{
                this.cangetLocation=true;
                if (isNetworkenaled) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES,this);


                if(locationManager!=null) {
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (location != null) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                }
                }
                if(isGpsEnabled){
                    if(location==null){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES,this);
                        if(locationManager!=null){
                            location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return location;
    }
    public void stopUsingGPS(){
        if(locationManager!=null){
            locationManager.removeUpdates(GpsTracker.this);
        }
    }
    public double getLatitude(){
        if(location!=null) {
            latitude = location.getLatitude();
        }
            return latitude;

    }
    public double getLongitude(){
        if(location!=null) {
            longitude = location.getLongitude();
        }
            return longitude;
    }
    public boolean canGetLocation(){
        return this.cangetLocation;

    }
    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
        alertDialog.setTitle("GPS");
        alertDialog.setMessage("GPS IS NOT ENABLED DO YOU WANT TO ENABLE");
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);

            }
        });
        alertDialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();

            }
        });
        alertDialog.show();
    }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
