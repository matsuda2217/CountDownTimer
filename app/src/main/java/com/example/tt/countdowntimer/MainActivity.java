package com.example.tt.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends ActionBarActivity {
    TextView textView;
    Button btnStart,btnStop,btnP,btnC;
    String temp;
    String tms;
    long count;
    CountDownTimer c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textTime);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnP = (Button) findViewById(R.id.btnPause);
        btnC = (Button) findViewById(R.id.btnC);


        final CountDownTimer c =  new CountDownTimer(40000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                count = millisUntilFinished;
                 tms = String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(count),
                        TimeUnit.MILLISECONDS.toMinutes(count) -  TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(count)),
                        TimeUnit.MILLISECONDS.toSeconds(count) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(count)));

                textView.setText(tms);

                System.out.println(count);

            }

            @Override
            public void onFinish() {
                textView.setText("DONE!");
            }
        };




        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.cancel();
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                c.cancel();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 =  new CountDownTimer(count,1000) {
                    @Override
                    public void onTick(long i) {

                        long m = i;
                        tms = String.format("%02d:%02d:%02d",
                                TimeUnit.MILLISECONDS.toHours(m),
                                TimeUnit.MILLISECONDS.toMinutes(m) -  TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(m)),
                                TimeUnit.MILLISECONDS.toSeconds(m) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(m)));
                        System.out.println(tms);
                        textView.setText(tms);
                    }

                    @Override
                    public void onFinish() {
                        textView.setText("DONE!");
                    }
                };
                c1.start();
            }
        });
    }


}
