package com.example.sohyeon.emotionaldiary.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sohyeon.emotionaldiary.R;
import com.example.sohyeon.emotionaldiary.ui.Emotion_Happy;
import com.example.sohyeon.emotionaldiary.ui.Emotion_Mad;
import com.example.sohyeon.emotionaldiary.ui.Emotion_Sadness;

public class EmotionActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Activity act = this;
    Button Happy, Sadness, Mad, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_);
        Happy = (Button) findViewById(R.id.button5);
        Happy.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(act, Emotion_Happy.class);
                startActivity(intent);
            }
        });
        Sadness = (Button) findViewById(R.id.button6);
        Sadness.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(act, Emotion_Sadness.class);
                startActivity(intent);
            }
        });
        Mad = (Button) findViewById(R.id.button7);
        Mad.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(act, Emotion_Mad.class);
                startActivity(intent);
            }
        });

        back = (Button) findViewById(R.id.button90);
        back.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    act.finish();
                //imageView = (ImageView) findViewById(R.id.image_view);
            }
        });
    }
}

