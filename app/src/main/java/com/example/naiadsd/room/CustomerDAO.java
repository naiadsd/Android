package com.example.naiadsd.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CustomerDAO {
    @Query("SELECT * FROM CustomerTable")
    List<CustomerTable> getAll();

    @Query("SELECT * FROM CustomerTable where (CustomerName Like '%'|| :newText ||'%')")
    List<CustomerTable> getAllSustomersByString(String newText);

    @Query("DELETE FROM CustomerTable")
    void deleteAll();
   /* @Query("SELECT * FROM StockTakeTable WHERE divisionID IN (SELECT divisionID FROM CustomerTable WHERE customerId=:customerId)")
    List<StockTakeTable> getAllByCustomer(String customerId);*/







    // Master data updates
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(CustomerTable customerTable);

}
