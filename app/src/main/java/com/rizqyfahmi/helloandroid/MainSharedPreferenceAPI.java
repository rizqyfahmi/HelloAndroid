package com.rizqyfahmi.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainSharedPreferenceAPI extends AppCompatActivity {

    private SharedPreferenceConfig sharedPreferenceConfig;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shared_preference_api);

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        username = findViewById(R.id.shared_preference_api_username);
        password = findViewById(R.id.shared_preference_api_password);

        if (sharedPreferenceConfig.readLoginStatus()){
            startActivity(new Intent(this, SharedPreferenceAPISuccessActivity.class));
            finish();
        }
    }

    public void loginUser(View view) {
        String username = this.username.getText().toString();
        String password = this.password.getText().toString();

        if (username.equals(getResources().getString(R.string.user_name)) && password.equals(getResources().getString(R.string.user_password))){
            startActivity(new Intent(this, SharedPreferenceAPISuccessActivity.class));
            sharedPreferenceConfig.writeLoginStatus(true);
            finish();
        }else{
            Toast.makeText(this, "Login failed... Try again...", Toast.LENGTH_SHORT).show();
            this.username.setText("");
            this.password.setText("" );
        }
    }
}
