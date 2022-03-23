package com.example.naiadsd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.naiadsd.adapters.CustomerListAdapter;
import com.example.naiadsd.adapters.ProductListAdapter;
import com.example.naiadsd.pojos.Customer;
import com.example.naiadsd.pojos.Data;
import com.example.naiadsd.pojos.Items;
import com.example.naiadsd.pojos.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {
     RecyclerView
    recyclerView;
    ProductListAdapter itemAdapter;
    EditText etid;
    Button btnadd;
    String id;
    TextView txtCartTotal;
    RelativeLayout skuLayoutBottomBar;

    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        recyclerView = findViewById(R.id.recyclerView);
        skuLayoutBottomBar = findViewById(R.id.skuLayoutBottomBar);
        txtCartTotal = findViewById(R.id.txtCartTotal);

        skuLayoutBottomBar.setVisibility(View.VISIBLE);
        loadSkuDetails();


    }

    public void loadSkuDetails(){
        Call<Product> call = null;
        RetrofitAPI apiService = RetrofitBuilder.getInstance(this).create(RetrofitAPI.class);
        call = apiService.getitems();
        call.enqueue(new Callback<Product>() {

            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {

                    List<Items> itemsList = response.body().getItems();
                    itemAdapter = new ProductListAdapter(ProductListActivity.this, itemsList, skuLayoutBottomBar, txtCartTotal);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductListActivity.this);
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(ProductListActivity.this, DividerItemDecoration.VERTICAL);

                    recyclerView.addItemDecoration(dividerItemDecoration);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(itemAdapter);
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }


        });
    }

}