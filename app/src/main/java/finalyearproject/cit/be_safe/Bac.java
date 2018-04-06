package finalyearproject.cit.be_safe;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

/**
 * Created by Rahul on 2/20/2016.
 */
public class Bac extends ActionBarActivity {
    Button next;
    SQLiteDatabase users=null;
    SQLiteDatabase userss=null;
    SQLiteDatabase userssd=null;
    EditText drinks,hours;
    String wt;
    String bw;
    String drink;
    String hrs;
    double weit,bweit,bc,bcs =70;
    int dr,hor;
    String bacv;
    int bacvalue;
    int counter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bac);
        drinks=(EditText)findViewById(R.id.drinks);
        hours=(EditText)findViewById(R.id.time);
        next=(Button)findViewById(R.id.bacbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userss = openOrCreateDatabase("result", MODE_PRIVATE, null);
                userss.execSQL("CREATE TABLE IF NOT EXISTS bacvalue" + "(bac VARCHAR);");
                Cursor cursors = userss.rawQuery("SELECT * FROM bacvalue", null);
                int bacid = cursors.getColumnIndex("bac");
                cursors.moveToFirst();
                if (cursors != null && (cursors.getCount() > 0)) {
                    do{
                        String bacv = cursors.getString(bacid);
                        bacv.trim();
                        bacvalue=Integer.parseInt(bacv);
                        //Toast.makeText(Bac.this, "Hello", Toast.LENGTH_SHORT).show();
                    }while(cursors.moveToNext());

                }
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
                        String drink = drinks.getText().toString().trim();
                        String hrs = hours.getText().toString().trim();
                        //String details = "hey" + name + ":" + bw + ":" + weight + ":" + phone + ":" + drink + ":" + hrs + ":" + bc;
                        //hours.setText(details);
                        int dr = Integer.parseInt(drink);
                        int hor = Integer.parseInt(hrs);
                        double mr = 0.016;
                        double bws = Double.parseDouble(bw);
                        int wt = Integer.parseInt(weight);
                        double bc = (float) ((0.806 * dr * 1.2) / (bws * wt)) - (mr * hor);
                        if((bc > 0.05) && (bacvalue>=5) ){

                            Intent opena=new Intent("finalyearproject.cit.be_safe.NO");
                            startActivity(opena);

                        }
                        else
                        {
                            Intent opena=new Intent("finalyearproject.cit.be_safe.YESA");
                            startActivity(opena);
                        }
                        bac = String.valueOf(bc);
                    } while (cursor.moveToNext());
                    Toast.makeText(getApplication(), "Info Recorded" + bac, Toast.LENGTH_LONG).show();


                }
            }
        });

    }
}
