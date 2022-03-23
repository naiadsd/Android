package com.example.naiadsd.pojos;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("customerId")
    private String CustomerId;

    @SerializedName("shipToAddressLineOne")
    private String ShiptoAddressLineOne;

    @SerializedName("customerName")
    private String CustomerName;


    public String getShiptoAddressLineOne() {
        return ShiptoAddressLineOne;
    }

    public void setShiptoAddressLineOne(String shiptoAddressLineOne) {
        ShiptoAddressLineOne = shiptoAddressLineOne;
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


}
