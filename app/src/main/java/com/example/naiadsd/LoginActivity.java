package com.example.naiadsd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText et_username, et_password;
    MaterialCheckBox cbRememberMe;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username = (TextInputEditText) findViewById(R.id.et_username);
        et_password = (TextInputEditText) findViewById(R.id.et_password);
        cbRememberMe = (MaterialCheckBox) findViewById(R.id.cbRememberMe);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                validateUser();
                break;
        }
    }

    public void validateUser(){
        if (et_username.getText().toString().isEmpty()){
            et_username.setError("please enter user name");

        }else if (et_password.getText().toString().isEmpty()){
            et_password.setError("please enter password");
        }else {
            Intent i = new Intent(LoginActivity.this, CustomerListActivity.class);
            startActivity(i);
        }
    }


}