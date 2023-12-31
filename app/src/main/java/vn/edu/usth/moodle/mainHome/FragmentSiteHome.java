package vn.edu.usth.moodle.mainHome;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.usth.moodle.R;
import vn.edu.usth.moodle.courseCategories.CourseCategories;

public class FragmentSiteHome extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_site_home, container, false);

        Button category = view.findViewById(R.id.categories);

        category.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), CourseCategories.class);
            startActivity(intent);
        });

        return view;
    }
}