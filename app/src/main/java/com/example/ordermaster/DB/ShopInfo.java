package com.example.ordermaster.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopinfo", indices = @Index(value = "id"))
public class ShopInfo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "menuName")
    private String menuName;

    @ColumnInfo(name = "menuPrice")
    private int menuPrice;

    public ShopInfo(String name, String menuName, int menuPrice) {
        this.name = name;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }
}
