package vn.edu.usth.moodle.courseCategories.ThirdYear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.usth.moodle.R;
import vn.edu.usth.moodle.Sidebar.NavGrade.ListAdapterGrades;
import vn.edu.usth.moodle.Sidebar.NavGrade.UserGrades;
import vn.edu.usth.moodle.Subjects.MobileApp.dashboardMobileApp;
import vn.edu.usth.moodle.Subjects.dashboardWebApp;
import vn.edu.usth.moodle.courseCategories.ThirdYear.Courses.ComputerGraphic;
import vn.edu.usth.moodle.databinding.DashboardMobileAppBinding;
import vn.edu.usth.moodle.databinding.DashboardWebAppBinding;

public class ThirdYear extends AppCompatActivity {
    String[] listCourses = {
            "Mobile Application Development",
            "Web Application Development",
            "Computer Graphic (2022-2023)",
            "Introduction to cryptography",
            "Applied Data Science with Python",
            "Information Security",
            "Advanced Databases",
            "Machine Learning and Data Mining",
            "Distributed System",
            "Graph Theory"
            };
    int[] pictureCourses = {R.drawable.database,R.drawable.machine,R.drawable.mobile, R.drawable.web,R.drawable.database,R.drawable.machine,R.drawable.mobile, R.drawable.web,R.drawable.database,R.drawable.machine};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_year);

        listView = (ListView) findViewById(R.id.custom_list_view);
        ListAdapterCourses listAdapterCourses = new ListAdapterCourses(getApplicationContext(), listCourses, pictureCourses);
        listView.setAdapter(listAdapterCourses);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = listCourses[position];

                switch (selectedCourse) {
                    case "Mobile Application Development":
                        Intent mobileIntent = new Intent(ThirdYear.this, dashboardMobileApp.class);
                        startActivity(mobileIntent);
                        break;
                    case "Web Application Development":
                        Intent webIntent = new Intent(ThirdYear.this, dashboardWebApp.class);
                        startActivity(webIntent);
                        break;
                    case "Computer Graphic (2022-2023)":
                        Intent computerGraphicIntent = new Intent(ThirdYear.this, ComputerGraphic.class);
                        startActivity(computerGraphicIntent);
                        break;
                    default:

                }
            }
        });


        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}