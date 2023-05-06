package com.example.lottery;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;


public class ConfigActivity extends AppCompatActivity {
    private EditText titleEditText;
    private ImageView lotteryBgImageView, imageBImageView, imageCImageView, imageDImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        titleEditText = findViewById(R.id.title_edittext);
        // 设置titleEditText默认值为lottery_title
        titleEditText.setText(getIntent().getStringExtra("title"));
        lotteryBgImageView = findViewById(R.id.lotterybg_imageview);
        imageBImageView = findViewById(R.id.image_b_imageview);
        imageCImageView = findViewById(R.id.image_c_imageview);
        imageDImageView = findViewById(R.id.image_d_imageview);

        Button btnAction = findViewById(R.id.btn_action);
        final int[] i = {1};
        lotteryBgImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i[0] = 1;
                onImageClick(v);
            }
        });
        imageBImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i[0] = 2;
                onImageClick(v);
            }
        });
        imageCImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i[0] = 3;
                onImageClick(v);
            }
        });
        imageDImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i[0] = 4;
                onImageClick(v);
            }
        });

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vt = titleEditText.getText().toString();
                if (vt != null && vt.length() > 0) {
                    MainActivity.setTitleEditText(titleEditText.getText().toString());
                }
                if (i[0] == 1) {
                    MainActivity.setBgImage(R.drawable.lotterybg);
                } else if (i[0] == 2) {
                    MainActivity.setBgImage(R.drawable.image_b);
                } else if (i[0] == 3) {
                    MainActivity.setBgImage(R.drawable.image_c);
                } else if (i[0] == 4) {
                    MainActivity.setBgImage(R.drawable.image_d);
                }
                finish();
            }
        });
    }

    public void onImageClick(View v) {
        switch (v.getId()) {
            case R.id.lotterybg_imageview:
                lotteryBgImageView.setBackgroundResource(R.drawable.image_bg_yellow);
                imageBImageView.setBackgroundResource(R.drawable.image_bg);
                imageCImageView.setBackgroundResource(R.drawable.image_bg);
                imageDImageView.setBackgroundResource(R.drawable.image_bg);
                break;
            case R.id.image_b_imageview:
                lotteryBgImageView.setBackgroundResource(R.drawable.image_bg);
                imageBImageView.setBackgroundResource(R.drawable.image_bg_yellow);
                imageCImageView.setBackgroundResource(R.drawable.image_bg);
                imageDImageView.setBackgroundResource(R.drawable.image_bg);
                break;
            case R.id.image_c_imageview:
                lotteryBgImageView.setBackgroundResource(R.drawable.image_bg);
                imageBImageView.setBackgroundResource(R.drawable.image_bg);
                imageCImageView.setBackgroundResource(R.drawable.image_bg_yellow);
                imageDImageView.setBackgroundResource(R.drawable.image_bg);
                break;
            case R.id.image_d_imageview:
                lotteryBgImageView.setBackgroundResource(R.drawable.image_bg);
                imageBImageView.setBackgroundResource(R.drawable.image_bg);
                imageCImageView.setBackgroundResource(R.drawable.image_bg);
                imageDImageView.setBackgroundResource(R.drawable.image_bg_yellow);
                break;
        }
    }
}

