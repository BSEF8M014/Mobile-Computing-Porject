package learnhubstudio.auditing;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.HashMap;

public class menu extends AppCompatActivity {

    Button button1, button2, button3, mcqbtn;
    AdView mAdView, m1AdView;
    InterstitialAd mInterstitialAd;
    AdRequest adRequest, adRequest1;

    public static boolean isAppRunning;
    private FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
    private HashMap<String, Object> firebaseDefaultMap;
    public static final String VERSION_CODE_KEY = "latest_app_version";    private static final String TAG = "menu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mAdView = (AdView) findViewById(R.id.adViewm);
        m1AdView = (AdView) findViewById(R.id.adViewm1);
        adRequest = new AdRequest.Builder().build();
        adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        m1AdView.loadAd(adRequest1);


        button1 = (Button) findViewById(R.id.start);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts = new Intent(menu.this, MainActivity.class);
                startActivity(starts);
            }
        });

        mcqbtn = (Button) findViewById(R.id.mcq);
        mcqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(menu.this, mcqs.class);
                startActivity(m);
            }
        });

        button2 = (Button) findViewById(R.id.about);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(menu.this, about.class);
                startActivity(i);
            }
        });

        button2 = (Button) findViewById(R.id.policy);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(menu.this, privacy_policy.class);
                startActivity(i);
            }
        });

        button3 = (Button) findViewById(R.id.exit);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(menu.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Exit");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.show();

            }
        });




        //////////update dialog via firebase start here part 1
//This is default Map
        firebaseDefaultMap = new HashMap<>();
        //Setting the Default Map Value with the current version code
        firebaseDefaultMap.put(VERSION_CODE_KEY, getCurrentVersionCode());

        //Setting that default Map to Firebase Remote Config
        mFirebaseRemoteConfig.setDefaults(firebaseDefaultMap);

        //Setting Developer Mode enabled to fast retrieve the values
        mFirebaseRemoteConfig.setConfigSettings(
                new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(BuildConfig.DEBUG)
                        .build());

        //Fetching the values here
        mFirebaseRemoteConfig.fetch().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    mFirebaseRemoteConfig.activateFetched();
                    Log.d(TAG, "Fetched value: " + mFirebaseRemoteConfig.getString(VERSION_CODE_KEY));
                    //calling function to check if new version is available or not
                    checkForUpdate();
                }else
                    Toast.makeText(menu.this,"Someting went wrong please try again", Toast.LENGTH_SHORT).show();
            }
        });

        Log.d(TAG, "Default value: " + mFirebaseRemoteConfig.getString(VERSION_CODE_KEY));

    }

    private void checkForUpdate() {
        int latestAppVersion = (int) mFirebaseRemoteConfig.getDouble(VERSION_CODE_KEY);
        if (latestAppVersion > getCurrentVersionCode()) {
            new AlertDialog.Builder(this)
                    .setTitle("Update!")
                    .setMessage("New version available.\n Please update.").setPositiveButton(
                    "Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=learnhubstudio.auditing"));
                            startActivity(intent);
                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                     }
            }).setCancelable(true).show();
        } else {
            Toast.makeText(this,"Upto date", Toast.LENGTH_SHORT).show();
        }


        //////////update dialog via firebase end here part 1
        /////FCM
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "1";
        String channel2 = "2";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId,
                    "Channel 1",NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.setDescription("This is BNT");
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel);

            NotificationChannel notificationChannel2 = new NotificationChannel(channel2,
                    "Channel 2",NotificationManager.IMPORTANCE_MIN);

            notificationChannel.setDescription("This is bTV");
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel2);
        }

}
        public void rateMe (View v){
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + "learnhubstudio.auditing")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + "learnhubstudio.auditing")));
            }
        }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.show();
    }



    //////////update dialog via firebase start here part 2
    private int getCurrentVersionCode() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
    //////////update dialog via firebase start here part 2



}
