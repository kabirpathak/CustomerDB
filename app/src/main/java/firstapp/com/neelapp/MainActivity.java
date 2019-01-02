package firstapp.com.neelapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    static int count = 0;
    TextView txt;Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loadEnterDetails(View v){
        Intent intent = new Intent(this, EnterDetails.class);
        startActivity(intent);
    }

    public void loadViewDetails(View v){
        Intent intent = new Intent(this, ViewDetails.class);
        startActivity(intent);
    }
}
