package finalyearproject.cit.be_safe;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Rahul on 4/8/2016.
 */
public class Gcolorc extends ActionBarActivity {
    SQLiteDatabase users=null;
    GpsTracker gps;
    Button white,red,blue,green,yellow,black,indigo,orange,violet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colorg);
        white=(Button)findViewById(R.id.button2);
        red=(Button)findViewById(R.id.button3);
        blue=(Button)findViewById(R.id.button4);
        green=(Button)findViewById(R.id.button5);
        yellow=(Button)findViewById(R.id.button6);
        black=(Button)findViewById(R.id.button7);
        indigo=(Button)findViewById(R.id.button8);
        orange=(Button)findViewById(R.id.button9);
        violet=(Button)findViewById(R.id.button10);
        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor1 = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor2 = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor3 = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor4 = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor5 = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor6 = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor7 = androidColors[new Random().nextInt(androidColors.length)];
        int randomAndroidColor8 = androidColors[new Random().nextInt(androidColors.length)];
        white.setTextColor(randomAndroidColor);
        red.setTextColor(randomAndroidColor1);
        blue.setTextColor(randomAndroidColor2);
        green.setTextColor(randomAndroidColor3);
        yellow.setTextColor(randomAndroidColor4);
        black.setTextColor(randomAndroidColor5);
        indigo.setTextColor(Color.GREEN);
        orange.setTextColor(randomAndroidColor7);
        violet.setTextColor(randomAndroidColor6);
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (white.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);

                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(red.getCurrentTextColor()== Color.GREEN){
                    Intent nes=new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);
                }
                else
                {
                    Toast.makeText(getApplication(),"Sorry you're not at all fit for driving",Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blue.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);
                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (green.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);
                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yellow.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);
                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (black.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);
                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        indigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indigo.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);

                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orange.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);

                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });
        violet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (violet.getCurrentTextColor() == Color.GREEN) {
                    Intent nes = new Intent("finalyearproject.cit.be_safe.YCOLORC");
                    startActivity(nes);

                } else {
                    Toast.makeText(getApplication(), "Sorry you're not at all fit for driving", Toast.LENGTH_LONG).show();
                    users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                    users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                    Cursor cursor = users.rawQuery("SELECT * FROM adduser", null);
                    int nameid = cursor.getColumnIndex("name");
                    int bwd = cursor.getColumnIndex("bw");
                    int weightid = cursor.getColumnIndex("weight");
                    int phoneid = cursor.getColumnIndex("phone");
                    cursor.moveToFirst();
                    if (cursor != null && (cursor.getCount() > 0)) {
                        String bac;
                        do {
                            String name = cursor.getString(nameid);
                            String bw = cursor.getString(bwd).trim();
                            String weight = cursor.getString(weightid).trim();
                            String phone = cursor.getString(phoneid);
                            SmsManager smsManager = SmsManager.getDefault();
                            gps=new GpsTracker(Gcolorc.this);
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
                    finish();
                }
            }
        });

    }
}
