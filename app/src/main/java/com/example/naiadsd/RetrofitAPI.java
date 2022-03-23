package com.example.naiadsd;

import com.example.naiadsd.pojos.Customer;
import com.example.naiadsd.pojos.Product;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("customer/getcustomers")

    Call<Customer> getAllCourses();

    @GET("item/getitems")
    Call<Product> getitems();
}
