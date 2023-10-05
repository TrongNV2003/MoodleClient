package vn.edu.usth.moodle.teacher_info.DetailTeacher1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.usth.moodle.R;

public class DetailTeacher1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teacher1);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView email = findViewById(R.id.email);

        // Set up a click listener for the button to open the link in the browser
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL you want to open
                String urlEmail = "https://mail.google.com/mail/u/1/#inbox?compose=GTvVlcSHxwCnLLSlznLTGMQpbPgcFhFLQhBZTXhfmLnlfmkqHFdkwbmpnCWQtgKhzfbJbrSZnbPlX"; // Replace with your desired URL

                // Create an Intent to open the URL in the default web browser
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlEmail));

                // Start the web browser activity
                startActivity(intent);
            }
        });

        TextView openLinkButton = findViewById(R.id.loadWebsiteButton);

        // Set up a click listener for the button to open the link in the browser
        openLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL you want to open
                String urlToOpen = "http://nguyenhoangha.net/"; // Replace with your desired URL

                // Create an Intent to open the URL in the default web browser
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlToOpen));

                // Start the web browser activity
                startActivity(intent);
            }
        });
    }
}