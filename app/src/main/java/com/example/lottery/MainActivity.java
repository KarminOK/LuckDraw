package com.example.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private PanelView lucky_panel;
    private Button btn_action;
    private Button btn_people;
    private Button btn_prize;

    private Button btn_theme;
    private TextView textView;
    private ScrollView scrollView;

    public static List<String> people = new ArrayList<>();
    public static List<Pair<String, Integer>> prize = new ArrayList<>();
    private static TextView titleEditText;
    private static FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        lucky_panel = (PanelView) findViewById(R.id.lucky_panel);
        btn_action = (Button) findViewById(R.id.btn_action);
        btn_people = (Button) findViewById(R.id.btn_people);
        btn_prize = (Button) findViewById(R.id.btn_prize);
        btn_theme = (Button) findViewById(R.id.btn_theme);
        textView = (TextView) findViewById(R.id.scrolling_text);
        scrollView = (ScrollView) findViewById(R.id.scrolling_view);

        titleEditText = findViewById(R.id.title_edittext);
        frameLayout = findViewById(R.id.frameLayout);

//        textView.setMovementMethod(new ScrollingMovementMethod());

        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lucky_panel.isGameRunning()) {
                    if (people.size() == 0 || prize.size() == 0)
                    {
                        Toast.makeText(MainActivity.this, "pelease set people and prize first", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    textView.setText("");
                    textView.append("start\n");

                    lucky_panel.startGame();

                    Handler handler = new Handler();
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            loop();
                        }
                    };
                    handler.postDelayed(runnable, 3000);
                }
            }
        });

        btn_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PeopleActivity.class);
                startActivity(intent);
            }
        });

        btn_prize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrizeActivity.class);
                startActivity(intent);
            }
        });

        btn_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loop() {
        if (prize.size() == 0)
        {
            textView.append("finish");
            scrollView.fullScroll(View.FOCUS_DOWN);
            lucky_panel.tryToStop(0);
            return;
        }
        int index = new Random().nextInt(prize.size());
        String prizeName = prize.get(index).first;
        Integer num = prize.get(index).second;
        if (num == 1)
        {
            prize.remove(index);
        }
        else {
            prize.set(index, new Pair<>(prizeName, num -1));
        }

        index = new Random().nextInt(people.size());
        String name = people.get(index);

        textView.append(name + " get " + prizeName + "x1\n");
        scrollView.fullScroll(View.FOCUS_DOWN);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                loop();
            }
        };
        handler.postDelayed(runnable, 3000);
    }
    public static void setTitleEditText(String title) {
        titleEditText.setText(title);
    }
    public static void setBgImage(int resId) {
        frameLayout.setBackgroundResource(resId);
    }
}
