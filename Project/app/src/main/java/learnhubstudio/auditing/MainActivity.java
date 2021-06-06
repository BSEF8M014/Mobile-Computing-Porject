package learnhubstudio.auditing;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14;
    AdView mAdView,mAdView2;
    AdRequest adRequest1,adRequest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 =  findViewById(R.id.chapter1);
        btn2 =  findViewById(R.id.chapter2);
        btn3 =  findViewById(R.id.chapter3);
        btn4 =  findViewById(R.id.chapter4);
        btn5 =  findViewById(R.id.chapter5);
        btn6 =  findViewById(R.id.chapter6);
        btn7 =  findViewById(R.id.chapter7);
        btn8 =  findViewById(R.id.chapter8);
        btn9 =  findViewById(R.id.chapter9);
        btn10 = findViewById(R.id.chapter10);
        btn11 = findViewById(R.id.chapter11);
        btn12 = findViewById(R.id.chapter12);
        btn13 = findViewById(R.id.chapter13);
        btn14 = findViewById(R.id.chapter14);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);

        mAdView =  findViewById(R.id.adView);
        mAdView2 =  findViewById(R.id.adView2);
        adRequest1 = new AdRequest.Builder().build();
        adRequest2 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest1);
        mAdView2.loadAd(adRequest2);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.chapter1:
                Intent ch1 = new Intent(MainActivity.this, chapter1.class);
                startActivity(ch1);
                break;

            case R.id.chapter2:
                Intent ch2 = new Intent(MainActivity.this, chapter2.class);
                startActivity(ch2);
                break;

            case R.id.chapter3:
                Intent ch3 = new Intent(MainActivity.this, chapter3.class);
                startActivity(ch3);
                break;

            case R.id.chapter4:
                Intent ch4 = new Intent(MainActivity.this, chapter4.class);
                startActivity(ch4);
                break;

            case R.id.chapter5:
                Intent ch5 = new Intent(MainActivity.this, chapter5.class);
                startActivity(ch5);
                break;

            case R.id.chapter6:
                Intent ch6 = new Intent(MainActivity.this, chapter6.class);
                startActivity(ch6);
                break;

            case R.id.chapter7:
                Intent ch7 = new Intent(MainActivity.this, chapter7.class);
                startActivity(ch7);
                break;

            case R.id.chapter8:
                Intent ch8 = new Intent(MainActivity.this, chapter8.class);
                startActivity(ch8);
                break;

            case R.id.chapter9:
                Intent ch9 = new Intent(MainActivity.this, chapter9.class);
                startActivity(ch9);
                break;

            case R.id.chapter10:
                Intent ch10 = new Intent(MainActivity.this, chapter10.class);
                startActivity(ch10);
                break;

            case R.id.chapter11:
                Intent ch11 = new Intent(MainActivity.this, chapter11.class);
                startActivity(ch11);
                break;

            case R.id.chapter12:
                Intent ch12 = new Intent(MainActivity.this, chapter12.class);
                startActivity(ch12);
                break;

            case R.id.chapter13:
                Intent ch13 = new Intent(MainActivity.this, chapter13.class);
                startActivity(ch13);
                break;

            case R.id.chapter14:
                Intent ch14 = new Intent(MainActivity.this, chapter14.class);
                startActivity(ch14);
                break;

        }

    }
}
