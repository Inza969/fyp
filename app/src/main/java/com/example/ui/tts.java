package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class tts extends AppCompatActivity implements TextToSpeech.OnInitListener {
    EditText input;
    Button speak_button;
    Button copybutton;
    TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        tts  = new TextToSpeech(this,this);
        input = findViewById(R.id.input_field);
        speak_button = findViewById(R.id.speech_btn);
        copybutton = findViewById(R.id.copy_btn);
        copybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText",input.getText().toString());

                Toast.makeText(tts.this, "Copied text!", Toast.LENGTH_SHORT).show();
            }
        });

        speak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.UK);
            tts.setSpeechRate(1);
            tts.setPitch(1);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language not supported");
            } else{
                speak_button.setEnabled(true);
                speak();
            }
        }

        else
        {
            Log.e("Text to speech", "Initialization failed");
        }

    }



    private void speak(){
        String message = input.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(message,TextToSpeech.QUEUE_FLUSH,null,null);
        }
    }


}







