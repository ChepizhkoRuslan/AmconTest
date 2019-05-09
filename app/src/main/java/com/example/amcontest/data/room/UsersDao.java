package com.example.amcontest.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;


@Dao
public interface UsersDao {
    // позволяет получить полный список users
    @Query("SELECT * FROM users")
    List<Users> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Users usersList);

}
