package finalyearproject.cit.be_safe;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {
    SQLiteDatabase users=null;//database varialble
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//to set layout
        users=openOrCreateDatabase("register",MODE_PRIVATE,null); //database connect
        users.execSQL("CREATE TABLE IF NOT EXISTS adduser"+"(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");// table created adduser
        Cursor cursor=users.rawQuery("SELECT * FROM adduser", null);//retrieve data from tsble
        int nameid=cursor.getColumnIndex("name");//to get id of table attrib
        int bwd=cursor.getColumnIndex("bw");
        int weightid=cursor.getColumnIndex("weight");
        int phoneid=cursor.getColumnIndex("phone");
        cursor.moveToFirst();
        if(cursor!=null&&(cursor.getCount()>0)){
            Thread timer =new Thread(){
                public  void run(){
                    try{
                        sleep(3000);
                    }catch(InterruptedException e){
                        e.printStackTrace();

                    }finally {
                        Intent openActivity=new Intent("finalyearproject.cit.be_safe.COLORC");
                        startActivity(openActivity);
                        finish();
                    }
                }
            };
            timer.start();

        }
    else{
            Thread timer =new Thread(){
                public  void run(){
                    try{
                        sleep(3000);
                    }catch(InterruptedException e){
                        e.printStackTrace();

                    }finally {
                        Intent openActivity1=new Intent("finalyearproject.cit.be_safe.REGISTER");
                        startActivity(openActivity1);
                        finish();
                    }
                }
            };
            timer.start();

        }
    }

}
