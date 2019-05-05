package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mTextUsername = (EditText) findViewById(R.id.EdiText_username);
        mTextPassword = (EditText) findViewById(R.id.EditText_password);
        mTextCnfPassword = (EditText) findViewById(R.id.EditText_cnf_password);
        mButtonRegister = (Button) findViewById(R.id.button_login);
        mTextViewLogin = (TextView) findViewById(R.id.TextView_register);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this , LoginActivity.class);
                startActivity(LoginIntent);
            }
        });
    }
}
