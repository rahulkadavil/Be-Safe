package finalyearproject.cit.be_safe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

/**
 * Created by Rahul on 2/21/2016.
 */
public class No extends ActionBarActivity {
    SQLiteDatabase users = null;
    Button msg;
    GpsTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no);
        msg = (Button) findViewById(R.id.smsno);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                final Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                final int nameid = cursor.getColumnIndex("name");
                final int bwd = cursor.getColumnIndex("bw");
                final int weightid = cursor.getColumnIndex("weight");
                final int phoneid = cursor.getColumnIndex("phone");
                cursor.moveToFirst();
                if (cursor != null && (cursor.getCount() > 0)) {
                    String bac;
                    do {
                        String name = cursor.getString(nameid);
                        String bw = cursor.getString(bwd).trim();
                        String weight = cursor.getString(weightid).trim();
                        String phone = cursor.getString(phoneid);
                        SmsManager smsManager = SmsManager.getDefault();
                        gps=new GpsTracker(No.this);
                        if(gps.canGetLocation()){
                            double latitude=gps.getLatitude();
                            double longitude=gps.getLongitude();
                            String locations="User Location \n"+"Latitude="+latitude+"\n"+"Longitude="+longitude+"\n"+"www.maps.google.com/?ie=UTF8&hq=&ll="
                                    +latitude+","+longitude;
                            smsManager.sendTextMessage(phone, null, name +locations+ " Not fit to drive - Be-Safe", null, null);
                            Toast.makeText(getApplication(), "SMS send", Toast.LENGTH_LONG).show();
                        }else{
                            gps.showSettingsAlert();
                        }


                    } while (cursor.moveToNext());
                }
            }
        });
    }


}