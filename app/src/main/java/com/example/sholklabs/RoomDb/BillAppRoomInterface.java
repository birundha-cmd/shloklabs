package com.example.sholklabs.RoomDb;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BillAppRoomInterface {

    @Insert
    void insertList(List<AddListDb> addListDb);

    @Query("SELECT * FROM addlistdb")
    List<AddListDb> getAll();

    @Query("DELETE  FROM addlistdb")
    void deleteList();

}
