package learnhubstudio.auditing;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class about extends AppCompatActivity {

    AdView mAdView;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mAdView = findViewById(R.id.adViewa);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }


    public void BrowseEmail(View view){
        TextView textView = (TextView) view;

        Intent emailIntent;
        emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"+textView.getText().toString()));

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {

        }

    }

    public void phone(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+923322253600"));
        startActivity(intent);
    }

}
