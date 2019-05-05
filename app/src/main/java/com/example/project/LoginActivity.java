package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    String username = "123";
    String password = "456";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTextUsername = (EditText) findViewById(R.id.EdiText_username);
        mTextPassword = (EditText) findViewById(R.id.EditText_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mTextViewRegister = (TextView) findViewById(R.id.TextView_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Route_setting.class);
                startActivity(intent);
            }
        });

      mButtonLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
           if((mTextUsername.getText().toString().equals(username)) && mTextPassword.getText().toString().equals(password)){
               Toast.makeText(LoginActivity.this,"登入成功",Toast.LENGTH_SHORT).show();
               Intent intent = new Intent();
               intent.setClass(LoginActivity.this , Set_routeActivity.class);
               startActivity(intent);
               finish();
           }
           else
               Toast.makeText(LoginActivity.this,"帳號或密碼錯誤",Toast.LENGTH_SHORT).show();
          }
      });


    }


}
