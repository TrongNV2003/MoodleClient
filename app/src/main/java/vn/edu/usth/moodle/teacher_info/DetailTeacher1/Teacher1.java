package vn.edu.usth.moodle.teacher_info.DetailTeacher1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.usth.moodle.R;
import vn.edu.usth.moodle.Sidebar.NavBlogActivity;

public class Teacher1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher1);



        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        TextView details = findViewById(R.id.detail);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Teacher1.this, DetailTeacher1.class);
                startActivity(intent);
            }
        });

        TextView badges = findViewById(R.id.badge);
        badges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Teacher1.this, BadgesTeacher1.class);
                startActivity(intent);
            }
        });

        TextView blog = findViewById(R.id.blog_entries);
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Teacher1.this, BlogTeacher1.class);
                startActivity(intent);
            }
        });


    }
}