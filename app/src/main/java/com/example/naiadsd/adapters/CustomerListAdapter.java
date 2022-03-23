package com.example.naiadsd.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naiadsd.CustomerListActivity;
import com.example.naiadsd.R;
import com.example.naiadsd.pojos.Customer;
import com.example.naiadsd.pojos.Data;
import com.example.naiadsd.room.CustomerTable;

import java.util.List;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.Recycle> {

    Activity activity;
    List<Data>customerList;
    OnListFragmentInteractionListener listener;

    public CustomerListAdapter(CustomerListActivity activity, List<Data> customerList, OnListFragmentInteractionListener onListFragmentInteractionListener) {

        this.activity=activity;
        this.customerList=customerList;
        this.listener=onListFragmentInteractionListener;
    }

    @NonNull
    @Override
    public Recycle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(activity).inflate(R.layout.customer_list_adapter,parent,false);
        return new Recycle(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle holder, int position) {
        holder.cutomer_name.setText(customerList.get(position).getCustomerName());
        holder.sequence.setText(customerList.get(position).getCustomerId());
        holder.address.setText(customerList.get(position).getShiptoAddressLineOne());
    }


    @Override
    public int getItemCount() {
        return customerList.size();
    }


    public class Recycle extends RecyclerView.ViewHolder {
        TextView cutomer_name,sequence,address;
        Button btn_order;
        View mView;
        LinearLayout layout;
        //Button btnPicking;
        public Recycle(View itemView) {
            super(itemView);
            cutomer_name= (TextView) itemView.findViewById(R.id.cutomer_name);
            sequence= (TextView) itemView.findViewById(R.id.sequence);
            address= (TextView) itemView.findViewById(R.id.address);
            layout= (LinearLayout) itemView.findViewById(R.id.layout);
            btn_order= (Button) itemView.findViewById(R.id.btn_order);

            btn_order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != listener) {
                        // returns selected position to the fragment
                        int position=getAdapterPosition();
                        listener.onListFragmentInteraction(position);


                    }
                }
            });
        }
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(int pos);
    }
}
