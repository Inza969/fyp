package com.example.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;


public class viewPDF extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_p_d_f);

        pdfView = (PDFView) findViewById(R.id.view);
        String path = getExternalFilesDir(null).toString() + "/user.pdf";
        File file = new File(path);
        pdfView.fromFile(file)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .enableAnnotationRendering(false)
                .defaultPage(0)
                .password(null)
                .scrollHandle(null)
                .load();
    }
}