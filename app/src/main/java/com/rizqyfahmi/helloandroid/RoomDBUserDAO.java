package com.rizqyfahmi.helloandroid;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RoomDBUserDAO {

    @Insert
    public void addUser(RoomDBUser user);

    @Query("select * from users")
    public List<RoomDBUser> getUsers();

    @Update
    public void updateUser(RoomDBUser user);

    @Delete
    public void deleteUser(RoomDBUser user);

}
