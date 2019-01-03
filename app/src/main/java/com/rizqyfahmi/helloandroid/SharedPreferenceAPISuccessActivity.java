 package com.rizqyfahmi.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

 public class SharedPreferenceAPISuccessActivity extends AppCompatActivity {

     private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_api_success);

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

    }

     public void userLogout(View view) {
        this.sharedPreferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(this, MainSharedPreferenceAPI.class));
        finish();
     }
 }
