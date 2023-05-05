package com.example.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private final String username = "test";
    private final String password = "123";

    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.editText);
        editTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        buttonGo = (Button) findViewById(R.id.btn_action);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.equals(editTextUsername.getText().toString())
                    && password.equals(editTextPassword.getText().toString()))
                {
                    // go to main activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Username or Password error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
