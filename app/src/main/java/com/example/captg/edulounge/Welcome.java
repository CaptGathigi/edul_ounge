package com.example.captg.edulounge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView txtStudent, txtTutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtStudent = findViewById(R.id.txtStudent);
        txtTutor = findViewById(R.id.txtTutor);

        txtStudent.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){

            }
        });
        txtTutor.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){

            }
        });
        txtTutor.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){

                Intent signIn = new Intent(Welcome.this,SignIn.class);
                startActivity(signIn);

            }
        });

    }
}
