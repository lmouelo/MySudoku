package com.example.admin1.sudoku_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Bouton1 = (Button)  findViewById(R.id.easy);
        Button Bouton2 = (Button)  findViewById(R.id.hard);

        Bouton1.setOnClickListener(this);
        Bouton2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if( view.getId()==R.id.easy) {
            startActivities(new Intent[]{new Intent(this, Main2Activity.class)});
        }

        if( view.getId()==R.id.hard) {
            startActivities(new Intent[]{new Intent(this, Main2Activity.class)});
        }
    }

}
