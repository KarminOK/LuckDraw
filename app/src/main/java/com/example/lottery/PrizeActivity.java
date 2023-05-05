package com.example.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class PrizeActivity extends AppCompatActivity {

    EditText editText;
    Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize);

        editText = (EditText) findViewById(R.id.editText);
        buttonGo = (Button) findViewById(R.id.btn_action);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // parse prize list
                String str = editText.getText().toString();
                String[] arr = str.split("\n");
                if (arr.length == 0)
                {
                    Toast.makeText(PrizeActivity.this,"format error", Toast.LENGTH_SHORT).show();
                }
                else{
                    for (String line : arr) {
                        String[] prize = line.split("#");
                        if (prize.length != 2) {
                            Toast.makeText(PrizeActivity.this, "format error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String name = prize[0];
                        if (name.isEmpty())
                        {
                            Toast.makeText(PrizeActivity.this, "format error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Integer num = Integer.parseInt(prize[1]);
                        if (num <= 0)
                        {
                            Toast.makeText(PrizeActivity.this, "format error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        MainActivity.prize.add(new Pair<String, Integer>(name, num));
                    }
                    finish();
                }
            }
        });
    }
}
