package com.example.naiadsd.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.naiadsd.pojos.Customer;

@Database(entities = {CustomerTable.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {

    public abstract CustomerDAO getCustomerDAO();

}