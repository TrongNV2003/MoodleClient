package vn.edu.usth.moodle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import vn.edu.usth.moodle.NavBottom.BlogsFragment;
import vn.edu.usth.moodle.NavBottom.CalendarFragment;
import vn.edu.usth.moodle.NavBottom.MoreFragment;
import vn.edu.usth.moodle.NavBottom.NotificationFragment;
import vn.edu.usth.moodle.Sidebar.NavBlogActivity;
import vn.edu.usth.moodle.Sidebar.NavFile.NavFileActivity;
import vn.edu.usth.moodle.Sidebar.NavGrade.NavGradesFragment;
import vn.edu.usth.moodle.Sidebar.NavPreferencesActivity;
import vn.edu.usth.moodle.SignInUp.LoginActivity;
import vn.edu.usth.moodle.mainHome.FragmentHomeActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.bottom_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHomeActivity()).commit();
                } else if (itemId == R.id.notification) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationFragment()).commit();
                } else if (itemId == R.id.calendar) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendarFragment()).commit();
                } else if (itemId == R.id.blog) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BlogsFragment()).commit();
                } else if (itemId == R.id.more) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MoreFragment()).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentHomeActivity()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHomeActivity()).commit();
        } else if (itemId == R.id.nav_score) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NavGradesFragment()).commit();
        } else if (itemId == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NavFileActivity()).commit();
        } else if (itemId == R.id.nav_blog) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NavBlogActivity()).commit();
        } else if (itemId == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NavPreferencesActivity()).commit();
        } else if (itemId == R.id.nav_logout) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }

    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}