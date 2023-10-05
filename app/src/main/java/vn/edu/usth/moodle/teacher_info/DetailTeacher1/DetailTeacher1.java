package vn.edu.usth.moodle.teacher_info.DetailTeacher1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
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
        email.setMovementMethod(LinkMovementMethod.getInstance());
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/JGFT6LKmczk?si=d_WWCbNPAWwQGzLJ";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                if (intent.resolveActivity(getPackageManager()) != null) {

                    startActivity(intent);
                } else {

                    Toast.makeText(DetailTeacher1.this, "No web browser app found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}