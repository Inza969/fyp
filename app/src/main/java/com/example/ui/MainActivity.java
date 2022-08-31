package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView Translator,TTS, pdf,speech,textRec;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Translator = findViewById(R.id.translator_card);
        TTS= findViewById(R.id.tts_card);
        pdf = findViewById(R.id.pdf_card);
        speech = findViewById(R.id.speech_card);
        textRec = findViewById(R.id.text_card);
        toolbar = findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);

        //now click listener
        Translator.setOnClickListener(this);
        TTS.setOnClickListener(this);
        pdf.setOnClickListener(this);
        speech.setOnClickListener(this);
        textRec.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.share) {
            Toast.makeText(getApplicationContext(), "you clicked share", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.about) {
            Toast.makeText(getApplicationContext(), "you clicked abouy", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.logout) {
            Toast.makeText(getApplicationContext(), "you clicked abouy", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){

        case R.id.translator_card : i = new Intent(this,translator.class);
        startActivity(i);
        break;
            case R.id.speech_card : i = new Intent(this,speech.class);
            startActivity(i); break;
            case R.id.text_card : i = new Intent(this,text_recognition.class);startActivity(i);break;
            case R.id.tts_card : i = new Intent(this,tts.class);startActivity(i);break;
            case R.id.pdf_card : i = new Intent(this,pdf.class);startActivity(i);break;
            default:break;

    }
    }
}