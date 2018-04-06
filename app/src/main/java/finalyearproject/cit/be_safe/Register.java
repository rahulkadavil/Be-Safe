package finalyearproject.cit.be_safe;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Rahul on 2/19/2016.
 */
public class Register extends ActionBarActivity {
    SQLiteDatabase users=null;
    Button reg;
    EditText name,phone,weight;
    double bw;
    RadioButton ma,fe;
    String usname,usweight,usphone;
    int uw;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name=(EditText)findViewById(R.id.ename);
        weight=(EditText)findViewById(R.id.weight);
        phone=(EditText)findViewById(R.id.num);
        reg=(Button)findViewById(R.id.register);
        ma=(RadioButton)findViewById(R.id.male);
        fe=(RadioButton)findViewById(R.id.female);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        if(ma.isChecked()){
                            bw= (float) 0.58;
                        }else
                            bw= (float) 0.49;
                        usname= name.getText().toString();
                        usphone=phone.getText().toString();
                        usweight=weight.getText().toString();
                        users = openOrCreateDatabase("register", MODE_PRIVATE, null);
                        users.execSQL("CREATE TABLE IF NOT EXISTS adduser" + "(name VARCHAR,bw VARCHAR,weight int,phone VARCHAR);");
                        users.execSQL("INSERT INTO adduser (name,bw,weight,phone) VALUES ('" + usname + "','" + bw + "','" + usweight + "','" + usphone + "'); ");
                        Toast.makeText(getApplication(), "You are Registered", Toast.LENGTH_LONG).show();
                        Intent openActive = new Intent("finalyearproject.cit.be_safe.COLORC");
                        startActivity(openActive);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


        });
    }
}
