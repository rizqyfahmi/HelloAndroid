package com.rizqyfahmi.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainSQLite extends AppCompatActivity implements SQLiteHomeFragment.OnDbOpListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);

        if (findViewById(R.id.SQLite_fragment_container) != null){
            if (savedInstanceState != null){
                return;
            }

            SQLiteHomeFragment homeFragment = new SQLiteHomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.SQLite_fragment_container, homeFragment).commit();
        }
    }

    @Override
    public void dBOpPerformed(int method) {
        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.SQLite_fragment_container, new SQLiteAddContactFragment()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.SQLite_fragment_container, new SQLiteReadContactsFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.SQLite_fragment_container, new SQLiteUpdateFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.SQLite_fragment_container, new SQLiteDeleteFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
