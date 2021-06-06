package learnhubstudio.auditing;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class chapter8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter8);
        PDFView pdfView = findViewById(R.id.pdfch8);
        pdfView.fromAsset("8 Conpany Audit.pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }
}
