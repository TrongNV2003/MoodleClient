package vn.edu.usth.moodle.Courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.usth.moodle.R;
import vn.edu.usth.moodle.teacher_info.DetailTeacher1.Teacher1;

public class ComputerGraphic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_computer_graphic);

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView teacher1 = findViewById(R.id.teacher1);
        teacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComputerGraphic.this, Teacher1.class);
                startActivity(intent);
            }
        });
    }
}