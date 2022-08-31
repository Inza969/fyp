package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class pdf extends AppCompatActivity {

    EditText name;
    Button btnPdf,btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        name = (EditText) findViewById(R.id.name);
        btnPdf= (Button)  findViewById(R.id.btnpdf);
        btnView= (Button) findViewById(R.id.btnview);

        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                String path = getExternalFilesDir(null).toString() +"/user.pdf";
                File file  = new File(path);


                if(!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Document document = new Document(PageSize.A4);
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile()));
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                document.open();

                Font myfont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);

                Paragraph paragraph = new Paragraph();
                paragraph.add(new Paragraph("User Name:"+username, myfont));
                paragraph.add(new Paragraph("/n"));
                try {
                    document.add(paragraph);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }



                document.close();

                Toast.makeText(pdf.this, "PDF Created Successfully", Toast.LENGTH_SHORT).show();




            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(),viewPDF.class);
                startActivity(intent);
            }
        });
    }
}
