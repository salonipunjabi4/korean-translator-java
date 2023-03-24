package com.sp.koreanspeaker;

import android.content.pm.ActivityInfo;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etText;
    Button btnSpeak;
    TextView tvResult;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        etText = (EditText)findViewById(R.id.etText);
        btnSpeak = (Button)findViewById(R.id.btnSpeak);
        tvResult = (TextView)findViewById(R.id.tvResult);
        tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                    tts.setLanguage(Locale.KOREA);



        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = etText.getText().toString();
                if(s.length()==0)
                {
                    Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
                    etText.requestFocus();
                    return;
                }
                tvResult.setText(s);
                tts.speak(tvResult.getText().toString(),TextToSpeech.QUEUE_ADD,null);



                    }
                });
            }
        });


    }
}
