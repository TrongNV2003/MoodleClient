package vn.edu.usth.moodle.Courses.MobileApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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


        // Set up a click listener for the button to open the link in the browser
        openFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL you want to open
                String url = "https://moodle.usth.edu.vn/pluginfile.php/9211/mod_resource/content/1/1.%20intro.md.pdf";

                // Create an Intent to open the URL in the default web browser
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Start the web browser activity
                startActivity(intent);
            }
        });
    }



}