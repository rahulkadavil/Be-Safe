package finalyearproject.cit.be_safe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rahul on 5/4/2016.
 */
public class Bltooth extends ActionBarActivity {
    Button nxt;
    Btooth bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetuth);
        nxt=(Button)findViewById(R.id.bacnextbtn);
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt=new Btooth();
                Intent nestt = new Intent("finalyearproject.cit.be_safe.BAC");
                startActivity(nestt);
            }
        });
    }
}
