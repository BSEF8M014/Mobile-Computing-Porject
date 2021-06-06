package learnhubstudio.auditing;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class chapter9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter9);
        PDFView pdfView = findViewById(R.id.pdfch9);
        pdfView.fromAsset("9 cost accountion.pdf").enableSwipe(true).scrollHandle(new DefaultScrollHandle(this,true)).load();
    }
}
