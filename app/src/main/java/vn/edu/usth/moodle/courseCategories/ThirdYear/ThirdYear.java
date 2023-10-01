package vn.edu.usth.moodle.courseCategories.ThirdYear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import vn.edu.usth.moodle.R;
import vn.edu.usth.moodle.Courses.MobileApp.dashboardMobileApp;
import vn.edu.usth.moodle.Courses.dashboardDatabases;
import vn.edu.usth.moodle.Courses.dashboardMachineLearning;
import vn.edu.usth.moodle.Courses.dashboardWebApp;
import vn.edu.usth.moodle.Courses.ComputerGraphic;

public class ThirdYear extends AppCompatActivity {
    String[] listCourses = {
            "Mobile Application Development",
            "Web Application Development",
            "Machine Learning and Data Mining",
            "Advanced Databases",
            "Computer Graphic (2022-2023)",
            "Introduction to cryptography",
            "Applied Data Science with Python",
            "Information Security",
            "Distributed System",
            "Graph Theory"
            };
    int[] pictureCourses = {R.drawable.database,R.drawable.machine,R.drawable.mobile, R.drawable.web,
            R.drawable.database,R.drawable.machine,R.drawable.mobile, R.drawable.web,R.drawable.database,
            R.drawable.machine};

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
                    case "Machine Learning and Data Mining":
                        Intent machineIntent = new Intent(ThirdYear.this, dashboardMachineLearning.class);
                        startActivity(machineIntent);
                        break;
                    case "Advanced Databases":
                        Intent databaseIntent = new Intent(ThirdYear.this, dashboardDatabases.class);
                        startActivity(databaseIntent);
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