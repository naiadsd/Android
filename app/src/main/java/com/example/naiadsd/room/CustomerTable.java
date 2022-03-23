package com.example.naiadsd.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class CustomerTable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="CustomerId")
    public String CustomerId;

    @ColumnInfo(name = "CustomerName")
    public String CustomerName;

    @ColumnInfo(name = "ShiptoAddressLineOne")
    public String ShiptoAddressLineOne;

    public CustomerTable() {
    }

    public CustomerTable(String customerId, String customerName, String address) {
        CustomerId = customerId;
        CustomerName = customerName;
        ShiptoAddressLineOne = address;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return ShiptoAddressLineOne;
    }

    public void setAddress(String address) {
        ShiptoAddressLineOne = address;
    }
}
