package com.rizqyfahmi.helloandroid;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainRoomDBActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static RoomDBAppDatabase roomDBAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room_db);

        fragmentManager = getSupportFragmentManager();
        roomDBAppDatabase = Room.databaseBuilder(getApplicationContext(), RoomDBAppDatabase.class, "userdb").allowMainThreadQueries().build();

        if (findViewById(R.id.RoomDB_fragment_container) != null){

            if (savedInstanceState != null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.RoomDB_fragment_container, new RoomDBHomeFragment()).commit();
        }

    }
}
