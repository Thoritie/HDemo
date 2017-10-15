package com.example.handhelp.hdemo;

/**
 * Created by Thoritie on 10/13/17.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.widget.ListView;
import java.util.Locale;
import android.view.View.OnClickListener;


import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class SpeechActivity extends Activity{

//    private TextView txvResult;
    Button speak;
    ListView options;
    ArrayList<String> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speech);

//        txvResult = (TextView) findViewById(R.id.txvResult);
        speak = (Button) findViewById(R.id.btnSpeak);
        options = (ListView) findViewById(R.id.listSay);

        speak.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // This are the intents needed to start the Voice recognizer
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");

                startActivityForResult(i, 1010);
            }
        });

        // retrieves data from the previous state. This is incase the phones
        // orientation changes
        if (savedInstanceState != null) {
            results = savedInstanceState.getStringArrayList("results");

            if (results != null)
                options.setAdapter(new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, results));
        }


    }


//    public void getSpeechInput(View view) {
//
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(intent, 10);
//        } else {
//            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
//        }
//    }



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        switch (requestCode) {
//            case 10:
//                if (resultCode == RESULT_OK && data != null) {
//                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                    txvResult.setText(result.get(0));
//                }
//                break;
//        }
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        // retrieves data from the VoiceRecognizer
        if (requestCode == 1010 && resultCode == RESULT_OK) {
            results = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            options.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, results));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // This should save all the data so that when the phone changes
        // orientation the data is saved
        super.onSaveInstanceState(outState);

        outState.putStringArrayList("results", results);
    }

    public void BackPageSpeech  (View view){
        Button btn_back =(Button)findViewById(R.id.button);
        Intent intent = new Intent(SpeechActivity.this,MainActivity.class);
        startActivity(intent);
    }


}
