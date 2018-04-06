package finalyearproject.cit.be_safe;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static java.lang.StrictMath.random;


/**
 * Created by Rahul on 3/3/2016.
 */
public class Mathsq extends ActionBarActivity{
    EditText a3,a4,b3,c3,d3;
    SQLiteDatabase userss=null;
    TextView a1,a2,b1,b2,c1,c2,d1,d2;
    TextView t;
    Button proceed;
    Mathsq nw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathsq);
        a1=(TextView)findViewById(R.id.editTexta);
        a2=(TextView)findViewById(R.id.editText2a);
        a3=(EditText)findViewById(R.id.editText3a);
        b1=(TextView)findViewById(R.id.editTexts);
        b2=(TextView)findViewById(R.id.editText2s);
        b3=(EditText)findViewById(R.id.editText3s);
        c1=(TextView)findViewById(R.id.editTextm);
        c2=(TextView)findViewById(R.id.editText2m);
        c3=(EditText)findViewById(R.id.editText3m);
        d1=(TextView)findViewById(R.id.editTextd);
        d2=(TextView)findViewById(R.id.editText2d);
        d3=(EditText)findViewById(R.id.editText3d);
        t=(TextView)findViewById(R.id.timer);
        final int[] counter = {5};
        final int x1= (int) (random()*10);
        final int x2= (int) (random()*10);
        final int x3= (int) (random()*10);
        final int x4= (int) (random()*10);
        final int x5= (int) (random()*10);
        final int x6= (int) (random()*10);
        final int x7= (int) (random()*10);
        final int x8= (int) (random()*10);
        a1.setText(""+x1);
        a2.setText(""+x2);
        if(x3>x4) {
            b1.setText("" + x3);
            b2.setText("" + x4);
        }else
        {
            b1.setText("" + x4);
            b2.setText("" + x3);
        }
        c1.setText(""+x5);
        c2.setText(""+x6);
        if(x7>x8) {
            d1.setText("" + x7);
            d2.setText("" + x8);
        }
        else{
            d1.setText("" + x8);
            d2.setText("" + x7);
        }
        proceed=(Button)findViewById(R.id.procbtn);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String y1 = a3.getText().toString().trim();
                String y2 = b3.getText().toString().trim();
                String y3 = c3.getText().toString().trim();
                String y4 = d3.getText().toString().trim();
                final int sum = Integer.parseInt(y1);
                final int dif = Integer.parseInt(y2);
                final int mul = Integer.parseInt(y3);
                final int div = Integer.parseInt(y4);
                /*if ((sum == x1 + x2) && ((dif == x3 - x4)||(dif==x4-x3)) && (mul == x5 * x6) && ((div == x7 / x8)||(dif==x4-x3))) {
                    Intent opena = new Intent("finalyearproject.cit.be_safe.SSYESA");
                    startActivity(opena);
                    finish();
                } else {
                    Toast.makeText(getApplication(), "Your answers are wrong", Toast.LENGTH_LONG).show();
                }*/
                if(sum==x1+x2){
                    counter[0]++;
                }else{
                    counter[0]--;
                }
                if(dif == x3 - x4){
                    counter[0]++;
                }else{
                    counter[0]--;
                }
                if(div == x7 / x8){
                    counter[0]++;
                }else{
                    counter[0]--;
                }
                if(mul == x5 * x6){
                    counter[0]++;
                }else{
                    counter[0]--;
                }
                if(counter[0]>2){
                    userss = openOrCreateDatabase("result", MODE_PRIVATE, null);
                    userss.execSQL("CREATE TABLE IF NOT EXISTS bacvalue" + "(bac VARCHAR);");
                    userss.execSQL("INSERT INTO bacvalue (bac) VALUES ('" + 10 + "'); ");
                    Toast.makeText(getApplication(), "You are Answer is checked", Toast.LENGTH_LONG).show();
                    Intent openActive = new Intent("finalyearproject.cit.be_safe.SCOLORC");
                    startActivity(openActive);
                    nw=new Mathsq();
                    finish();
                    finishAndRemoveTask();

                }
                else{
                    userss = openOrCreateDatabase("result", MODE_PRIVATE, null);
                    userss.execSQL("CREATE TABLE IF NOT EXISTS bacvalue" + "(bac VARCHAR);");
                    userss.execSQL("INSERT INTO bacvalue (bac) VALUES ('" + 5 + "'); ");
                    Toast.makeText(getApplication(), "You are Answer is checked", Toast.LENGTH_LONG).show();
                    Intent openActive = new Intent("finalyearproject.cit.be_safe.SCOLORC");
                    startActivity(openActive);
                    finish();
                    finishAndRemoveTask();
                }
            }
        });
          CountDownTimer ct=  new CountDownTimer(30000,1000){

                @Override
                public void onTick(long millisUntilFinished) {
                    t.setText("Time remaining:"+millisUntilFinished/1000);
                }

                @Override
                public void onFinish() {

                    //Intent opena=new Intent("finalyearproject.cit.be_safe.SCOLORC");
                    //startActivity(opena);
                }
          };ct.start();
    }




}

