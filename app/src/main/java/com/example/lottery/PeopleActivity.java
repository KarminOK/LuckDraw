package com.example.lottery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class PeopleActivity extends AppCompatActivity {

    EditText editText;
    Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        editText = (EditText) findViewById(R.id.editText);
        buttonGo = (Button) findViewById(R.id.btn_action);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // parse member list
                String str = editText.getText().toString();
                String[] arr = str.split("\n");
                if (arr.length == 0)
                {
                    Toast.makeText(PeopleActivity.this,"format error", Toast.LENGTH_SHORT).show();
                }
                else{
                    MainActivity.people.addAll(Arrays.asList(arr));
                    finish();
                }
            }
        });
    }
}
