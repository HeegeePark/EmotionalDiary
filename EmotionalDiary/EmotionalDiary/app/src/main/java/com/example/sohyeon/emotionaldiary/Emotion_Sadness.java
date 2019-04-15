package com.example.sohyeon.emotionaldiary;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Emotion_Sadness extends AppCompatActivity{
    Activity act = this;
    String[] filenames = null;
    int fileindex = 0;
    ImageView imageView;
    Button bPrev, bNext,back;
    TextView countimage2;
    TextView txt_date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_emotion_sadness);
        countimage2 = (TextView) findViewById(R.id.countimage2);
        imageView = (ImageView) findViewById(R.id.image_view);
        back = (Button) findViewById(R.id.button90);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                act.finish();
                //imageView = (ImageView) findViewById(R.id.image_view);
            }
        });

        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
        txt_date = (TextView)findViewById(R.id.txt_date);
        txt_date.setText("Date : "+timeStamp);

        bPrev = (Button) findViewById(R.id.button_prev);
        bPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(filenames != null && fileindex > 0) {
                    fileindex -= 1;
                    DisplayImage(filenames[fileindex]);
                    countimage2.setText((fileindex + 1) + "/" + filenames.length);
                } else {
                    // Toast
                    Toast.makeText(act, "사진이 없습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });//이전 사진 보여주기

        bNext = (Button) findViewById(R.id.button_next);
        bNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(filenames != null && fileindex < filenames.length - 1) {
                    fileindex += 1;
                    DisplayImage(filenames[fileindex]);
                    countimage2.setText((fileindex + 1) + "/" + filenames.length);
                } else {
                    // Toast
                    Toast.makeText(act, "사진이 없습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });//다음 사진 보여주기

        String filename = "Sad.txt";

        String ret = "";

        InputStream inputStream = null;
        try {
            inputStream = openFileInput(filename);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int size = inputStream.available();
                char[] buffer = new char[size];

                inputStreamReader.read(buffer);

                inputStream.close();
                ret = new String(buffer);
                Log.d("TEST", "CONTENTS=" + ret);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!ret.equals("")) {
            filenames = ret.split("\n");
            List<String> Listfilenames = Arrays.asList(filenames);
            Collections.reverse(Listfilenames);

            countimage2.setText((fileindex + 1) + "/" + filenames.length);

            DisplayImage(filenames[0]);
        }
    }

    private void DisplayImage(String filename) {
        imageView.setImageURI(Uri.parse(filename));
    }
    protected  void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "종료!", Toast.LENGTH_LONG).show();
    }
}