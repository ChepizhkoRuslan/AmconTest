package com.example.amcontest.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Users {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "lat")
    private String lat;
    @ColumnInfo(name = "lng")
    private String lng;
    @ColumnInfo(name = "content")
    private String contentUsers;

    public Users() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getContentUsers() {
        return contentUsers;
    }

    public void setContentUsers(String contentUsers) {
        this.contentUsers = contentUsers;
    }
}
