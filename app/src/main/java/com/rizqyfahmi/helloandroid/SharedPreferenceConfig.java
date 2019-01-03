package com.rizqyfahmi.helloandroid;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferenceConfig(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public boolean readLoginStatus(){
        boolean status = false;
        status = this.sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;
    }

}
