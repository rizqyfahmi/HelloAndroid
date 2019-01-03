package com.rizqyfahmi.helloandroid;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {RoomDBUser.class}, version = 1)
public abstract class RoomDBAppDatabase extends RoomDatabase {

    public abstract RoomDBUserDAO roomDBUserDAO();


}
