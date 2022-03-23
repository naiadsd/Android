package com.example.naiadsd.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    @SerializedName("items")
    private List<Items> items;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
