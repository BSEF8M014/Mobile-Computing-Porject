package learnhubstudio.auditing;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class chapter13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter13);
        PDFView pdfView = findViewById(R.id.pdfch13);
        pdfView.fromAsset("13 Methord of costing .pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }
}
