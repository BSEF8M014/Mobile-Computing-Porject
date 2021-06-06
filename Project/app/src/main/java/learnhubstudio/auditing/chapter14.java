package learnhubstudio.auditing;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class chapter14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter14);
        PDFView pdfView = findViewById(R.id.pdfch14);
        pdfView.fromAsset("14 Elemement principal and techniques .pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }
}
