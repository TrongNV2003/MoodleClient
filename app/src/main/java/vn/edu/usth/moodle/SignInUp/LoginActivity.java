package vn.edu.usth.moodle.SignInUp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.moodle.DatabaseHelper;
import vn.edu.usth.moodle.MainActivity;
import vn.edu.usth.moodle.R;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login, signup;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signup = findViewById(R.id.signup1);
        login = findViewById(R.id.signin1);

        databaseHelper = new DatabaseHelper(this);

        login.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                Toast.makeText(LoginActivity.this, "Required an account", Toast.LENGTH_SHORT).show();
            else{
                Boolean checkUserPass = databaseHelper.checkUsernamePassword(user, pass);
                if(checkUserPass){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "This account does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        Button google = findViewById(R.id.google);

        // Set up a click listener for the button to open the link in the browser
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL you want to open
                String urlEmail = "https://accounts.google.com/AccountChooser?oauth=1&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Flegacy%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hAOQkE8YAWp0rZOfScZeVehUCLLhTEB5YQ0apDI7akTEW_Oe_a9phbGWocT2EIU082XUQtacXEDtaKWQTMxVmYFZA9Hk1Hf_YD8L7UB70KeNKe7zK4lH9AgjjyI-Q-PIH0O19mMC8NGMIOgz6ztJkPShs-wrvDldqGFuNJPHoeX5T21EaGhpa2Ldxv3rLhwqmkHu1pHOZ7Uw14ULzC7wOWMFgwDibbBJJdHP3pRRe88xT7HGmKXqDIdw_Fi1AdrTX9u3xlVIpteR4hCx2KKZpAnr3e5ao6S1fCLXb4VS4O8nTg9Z0SMg8P010ttey7kUK4HDDZIECkPF2nUzwpfqapPQov4JtfRjR5tSVK-3WVqd9JDC7P0BZTCEZNphf-jDrOyRTgurr_AFxOL3Ozq3yIYYDn-kIjlYhgPbNAp6Wkx8gzaczKjPuj7bWogw_nhJr4xg7hPqgf6z9l7IzJdMiIZF4xvNqQ%26as%3DS822898735%253A1696522995789022%26client_id%3D1071427813812-aj077fua4ap0qav6ioi10ok8jfjvt6n3.apps.googleusercontent.com%26theme%3Dglif%23"; // Replace with your desired URL

                // Create an Intent to open the URL in the default web browser
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlEmail));

                // Start the web browser activity
                startActivity(intent);
            }
        });

    }
}
