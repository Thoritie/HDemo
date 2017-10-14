package com.example.handhelp.hdemo;

/**
 * Created by Thoritie on 10/13/17.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class SpeechActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speech);
    }


    public void BackPageSpeech  (View view){
        Button btn_back =(Button)findViewById(R.id.button);
        Intent intent = new Intent(SpeechActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
