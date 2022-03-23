package com.example.naiadsd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.naiadsd.adapters.CustomerListAdapter;
import com.example.naiadsd.pojos.Customer;
import com.example.naiadsd.pojos.Data;
import com.example.naiadsd.room.AppDatabase;
import com.example.naiadsd.room.CustomerDAO;
import com.example.naiadsd.room.CustomerTable;
import com.example.naiadsd.room.RoomAppDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerListActivity extends AppCompatActivity {

    RecyclerView customerRecyclerview;
    CustomerListAdapter customerListAdapter;
    List<Customer> customers;
    /* //we will use these constants later to pass the artist name and id to another activity
     public static final String ARTIST_NAME = "net.simplifiedcoding.firebasedatabaseexample.artistname";
     public static final String ARTIST_ID = "net.simplifiedcoding.firebasedatabaseexample.artistid";*/
    FirebaseFirestore firebaseFirestore;
    CustomerDAO db;
    AppDatabase dataBase;
    private Customer customer;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerlist);
        gson = new GsonBuilder().create();
        customer = new Customer();
        customerRecyclerview = (RecyclerView) findViewById(R.id.customer_RecycleView);
        customers = new ArrayList<>();

        firebaseFirestore = FirebaseFirestore.getInstance();
        dataBase = new RoomAppDatabase(this).getAppDatabase();

        db = dataBase.getCustomerDAO();

        loadfromControllers();

    }

    public void loadfromControllers() {

        Call<Customer> call = null;
        RetrofitAPI apiService = RetrofitBuilder.getInstance(this).create(RetrofitAPI.class);
        call = apiService.getAllCourses();
        call.enqueue(new Callback<Customer>() {

            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                  if (response.isSuccessful()){

                List<Data>  dataList=     response.body().getData();
                      customerListAdapter = new CustomerListAdapter(CustomerListActivity.this,dataList , new CustomerListAdapter.OnListFragmentInteractionListener() {
                          @Override
                          public void onListFragmentInteraction(int pos) {

                              String customerId = dataList.get(pos).getCustomerId();
                            ProductListActivity productListActivity = new ProductListActivity();
                              Intent intent = new Intent(CustomerListActivity.this, ProductListActivity.class);
                              intent.putExtra("CustomerId", customerId);
                              startActivity(intent);


                          }
                      });
                      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CustomerListActivity.this);
                      DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(CustomerListActivity.this, DividerItemDecoration.VERTICAL);
                      dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
                      customerRecyclerview.addItemDecoration(dividerItemDecoration);

                      customerRecyclerview.setLayoutManager(linearLayoutManager);
                      customerRecyclerview.setAdapter(customerListAdapter);
                  }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

                       }


                  /*  gson.fromJson(String.valueOf(response.body()), Customer.class);

                    customerListAdapter = new CustomerListAdapter(CustomerListActivity.this,customers , new CustomerListAdapter.OnListFragmentInteractionListener() {
                        @Override
                        public void onListFragmentInteraction(int pos) {

                            String customerId = customers.get(pos).getCustomerId();
                            *ProductListActivity productListActivity = new ProductListActivity();
                            Intent intent = new Intent(CustomerListActivity.this, ProductListActivity.class);
                            intent.putExtra("CustomerId", customerId);
                            startActivity(intent);


                        }
                    });
*/
                    //attaching adapter to the listview
                   /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CustomerListActivity.this);
                           DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(CustomerListActivity.this, DividerItemDecoration.VERTICAL);
                            dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
                            customerRecyclerview.addItemDecoration(dividerItemDecoration);

                    customerRecyclerview.setLayoutManager(linearLayoutManager);
                    customerRecyclerview.setAdapter(customerListAdapter);
                    //do something with list of pojos retrieved
                }*/

        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater;
        inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.length()>3){
                    List<CustomerTable> customerTables = db.getAllSustomersByString(query);
                    searchView.clearFocus();
                    customerListAdapter = new CustomerListAdapter(CustomerListActivity.this, customerTables,null);
                    customerListAdapter.notifyDataSetChanged();

                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
*/

}
