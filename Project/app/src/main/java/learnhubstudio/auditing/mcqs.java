package learnhubstudio.auditing;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class mcqs extends AppCompatActivity {

    PDFView pdf;
    AdView mAdView,mAdView2;
    AdRequest adRequestm1,adRequestm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqs);

        pdf = findViewById(R.id.pdfmcqs);

        mAdView =  findViewById(R.id.adView_mcq1);
        mAdView2 =  findViewById(R.id.adView_mcq2);
        adRequestm1 = new AdRequest.Builder().build();
        adRequestm2 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequestm1);
        mAdView2.loadAd(adRequestm2);
    }

    @Override
    public void onBackPressed() {
        if (pdf.isShown()) {
            pdf.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    public void auditing_mcqs(View view) {
        pdf.setVisibility(View.VISIBLE);
        pdf.fromAsset("AUDITING MCQs.pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }

    public void cost_auditing(View view) {
        pdf.setVisibility(View.VISIBLE);
        pdf.fromAsset("cost accounting mcqs .pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }

    public void principle_auditing(View view) {
        pdf.setVisibility(View.VISIBLE);
        pdf.fromAsset("Principles of Auditing Mcqs.pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }

    public void financial_management(View view) {
        pdf.setVisibility(View.VISIBLE);
        pdf.fromAsset("Financial Management mcqs.pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }

    public void mix_auditing(View view) {
        pdf.setVisibility(View.VISIBLE);
        pdf.fromAsset("Mix 150 mcqs.pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }
}
