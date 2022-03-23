package com.example.naiadsd.pojos;

import com.google.gson.annotations.SerializedName;

public class OrderItem {
    @SerializedName("Id")
    private int Id;
    @SerializedName("OrderId")
    private String OrderId;

    @SerializedName("ProductId")
    private String ProductId;

    @SerializedName("Notes")
    private String Notes;

    @SerializedName("Quantity")
    private String Quantity;

    @SerializedName("Discount")
    private String Discount;

    @SerializedName("Amount")
    private String Amount;

    @SerializedName("CreatedBy")
    private String CreatedBy;


    @SerializedName("CreatedOn")
    private String CreatedOn;


    @SerializedName("UpdatedBy")
    private String UpdatedBy;

    @SerializedName("UpdatedOn")
    private String UpdatedOn;

    @SerializedName("IsActive")
    private String IsActive;

    @SerializedName("GetOrderItem")
    private String GetOrderItem;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    public String getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        UpdatedOn = updatedOn;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }

    public String getGetOrderItem() {
        return GetOrderItem;
    }

    public void setGetOrderItem(String getOrderItem) {
        GetOrderItem = getOrderItem;
    }
}

