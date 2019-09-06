package com.example.ordermaster.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ShopInfo.class}, version = 1)
public abstract class OrderMasterDatabase extends RoomDatabase {
    private static OrderMasterDatabase INSTANCE;
    private static final String DB_NAME = "ORDERMASTER.db";

    public static OrderMasterDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (OrderMasterDatabase.class) {
                INSTANCE = Room.databaseBuilder(context, OrderMasterDatabase.class, DB_NAME)
                        .allowMainThreadQueries()
                            //.addMigrations(내용 필용)
                        .build();
            }
        }
        return INSTANCE;
    }

    public abstract ShopDao shopDao();
}
