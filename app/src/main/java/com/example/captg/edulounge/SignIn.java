package com.example.captg.edulounge;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.captg.edulounge.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnSignIn;
    TextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtSignUp = findViewById(R.id.txtSignUp);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Loading....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //verify user exists

                        if (dataSnapshot.child(edtEmail.getText().toString()).exists()) {

                            mDialog.dismiss();
                            //Get User Info
                            User user = dataSnapshot.child(edtEmail.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {

                                Toast.makeText(SignIn.this, "Sign In successful!", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(SignIn.this, "Wrong Password!!!", Toast.LENGTH_SHORT).show();

                            }

                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "User Does Not Exist!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){

            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){

                Intent signUp = new Intent(SignIn.this,SignUp.class);
                startActivity(signUp);

            }
        });
    }
}
