package vn.edu.usth.moodle.Subjects.MobileApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

import vn.edu.usth.moodle.R;

public class MobileCourseIntroduction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_course_introduction);

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        Button openFiles = findViewById(R.id.open_btn);
        openFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFiles("1. intro.md.pdf");
            }
        });
    }

    private void openFiles(String pdfFileName) {
        Uri uri = Uri.parse("content://com.android.providers.downloads.documents/download/" + pdfFileName);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                // Handle the case where a PDF viewer app is not installed
                // You can prompt the user to install a PDF viewer here
            }
        }

}