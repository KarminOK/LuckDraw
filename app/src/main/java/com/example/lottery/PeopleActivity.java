package com.example.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
