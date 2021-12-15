package com.trifun.mymovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


//    String username;
//    String password;
    Button loginBtn;
    EditText etName, etPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView username = (TextView) findViewById(R.id.etName);
        TextView password = (TextView) findViewById(R.id.etPassword);

        Button loginBtn = (Button) findViewById(R.id.btnLogin);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().toString().equals("MockUsername") && password.getText().toString().equals("Test123!")){

                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(getApplicationContext(), Movies.class);
                    bundle.putString("EXTRA_USERNAME", username.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);



                }else
                    Toast.makeText(MainActivity.this, "LOG IN FAILED!!! INVALID USER NAME OR PASSWORD",Toast.LENGTH_LONG).show();
               }
        });



        }


    public void enableButton(Boolean enable) {
        loginBtn.setEnabled(enable);
    }

    public void checkFields() {
        if(etName.getText().toString().length() > 5 &&
                etPassword.getText().toString().length() > 8) {
            enableButton(true);
        } else {
            enableButton(false);
        }

    }}

