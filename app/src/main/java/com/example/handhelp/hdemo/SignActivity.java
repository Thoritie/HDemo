package com.example.handhelp.hdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thoritie on 10/14/17.
 */

public class SignActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

    }

    public void BackPageSign  (View view){
        Button btn_back =(Button)findViewById(R.id.button2);
        Intent intent = new Intent(SignActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
