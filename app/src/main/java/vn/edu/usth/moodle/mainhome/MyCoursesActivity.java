package vn.edu.usth.moodle.mainhome;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.usth.moodle.R;
import vn.edu.usth.moodle.dashboard.dashboardDatabases;
import vn.edu.usth.moodle.dashboard.dashboardMachineLearning;
import vn.edu.usth.moodle.dashboard.dashboardWebApp;

public class MyCoursesActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_courses, container, false);

        Button button = view.findViewById(R.id.machine);
        button.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), dashboardMachineLearning.class);
            startActivity(intent);
        });

        return view;
    }
}