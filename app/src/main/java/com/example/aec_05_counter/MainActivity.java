package com.example.aec_05_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView counterText;
    Button start,stop;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
        handleStartBTN();
        handleStopBTN();
    }
    public void initializer(){
        counterText = findViewById(R.id.counterText);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        handler = new Handler();

    }

    public void handleStartBTN(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int val = Integer.parseInt(counterText.getText().toString());
                startCounter();
//                Toast.makeText(MainActivity.this, counterText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void  startCounter(){

        runnable = new Runnable() {
            @Override
            public void run() {
                getAndSetData();
                handler.postDelayed(this,100);
            }
        };
        handler.post(runnable);

    }
    public void getAndSetData(){
        int val = Integer.parseInt(counterText.getText().toString());
        String num = String.valueOf(val+1);
        counterText.setText(num);
    }
    public void handleStopBTN(){
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
                Toast.makeText(MainActivity.this, "Counter Stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}