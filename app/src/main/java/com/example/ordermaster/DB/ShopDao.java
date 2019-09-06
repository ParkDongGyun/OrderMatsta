package com.example.ordermaster.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShopDao {

    @Query("Select * From shopinfo")
    LiveData<List<ShopInfo>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ShopInfo shopInfo);

    @Update
    void update(ShopInfo shopInfo);

    @Delete
    void delete(ShopInfo shopInfo);
}
