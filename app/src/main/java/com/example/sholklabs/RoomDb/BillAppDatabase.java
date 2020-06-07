package com.example.sholklabs.RoomDb;



import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AddListDb.class,}, version = 1 )
public  abstract  class BillAppDatabase extends RoomDatabase {

    public abstract BillAppRoomInterface billAppRoomInterface();

}
