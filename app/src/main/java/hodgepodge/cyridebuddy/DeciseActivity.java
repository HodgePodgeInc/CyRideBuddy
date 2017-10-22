package hodgepodge.cyridebuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DeciseActivity extends AppCompatActivity {


    public Button bot1;
    public Button bot2;

    public void init(){

        ArrayList<Button> list = new ArrayList<>();
        bot1 = (Button)findViewById(R.id.north);
        bot2 = (Button)findViewById(R.id.south);
        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoSec = new Intent(DeciseActivity.this, LocationActivity.class);

                startActivity(gotoSec);
            }
        });
        bot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoSec = new Intent(DeciseActivity.this, LocationActivity.class);

                startActivity(gotoSec);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decise);
        init();
    }
}
