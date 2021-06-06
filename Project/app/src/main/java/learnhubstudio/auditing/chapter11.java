package learnhubstudio.auditing;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class chapter11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter11);
        PDFView pdfView = findViewById(R.id.pdfch11);
        pdfView.fromAsset("11 reconcilation of profit as per cost .pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }
}
