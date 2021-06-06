package learnhubstudio.auditing;


import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ImageView iv = findViewById(R.id.image);
        TextView tv = findViewById(R.id.welcomeText);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        iv.startAnimation(animation);
        tv.startAnimation(animation);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l= findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        final Intent i = new Intent(this, menu.class);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}