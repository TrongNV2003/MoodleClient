package vn.edu.usth.moodle.Sidebar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import vn.edu.usth.moodle.R;

public class NavGradesActivity extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_grade, container, false);

        ListView listView = view.findViewById(R.id.list_view);

        String[] items = {
                "[I12-S1] MAT1.001 CALCULUS I: 20",
                "[I12-S1] MAT1.002 LINEAR ALGEBRA: 18",
                "[I12-S1] BIO1.001 CELLULAR BIOLOGY: 15",
                "[I12-S1] CHE1.001 GENERAL CHEMISTRY I: 17",
                "[I12-S1] PHY1.001 FUNDAMENTAL PHYSIC I: 20"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        return view;
    }
}