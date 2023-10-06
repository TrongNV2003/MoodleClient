package vn.edu.usth.moodle.Sidebar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import vn.edu.usth.moodle.R;
import vn.edu.usth.moodle.SignInUp.LoginActivity;

public class NavHeader extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth auth;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        textView = (TextView) findViewById(R.id.email_text);

        String userEmail = user.getEmail();
        textView.setText(userEmail);
        Log.d("EmailDebug", "User Email: " + userEmail);
    }
}