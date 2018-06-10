package com.example.captg.edulounge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSignUp,btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){

            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){

                Intent welcome = new Intent(MainActivity.this,Welcome.class);
                startActivity(welcome);

            }
        });
    }
}
