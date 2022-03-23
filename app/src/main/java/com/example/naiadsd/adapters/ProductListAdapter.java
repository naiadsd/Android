package com.example.naiadsd.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naiadsd.CustomerListActivity;
import com.example.naiadsd.R;
import com.example.naiadsd.pojos.Customer;
import com.example.naiadsd.pojos.Items;
import com.example.naiadsd.room.CustomerTable;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.Recycle> {

    List<Items> itemsList;
    Context context;
    RelativeLayout skuLayoutBottomBar;
    TextView txtCartTotal;
    OnListFragmentInteractionListener listener;

    public ProductListAdapter(Context context, List<Items> itemsList, RelativeLayout skuLayoutBottomBar, TextView txtCartTotal) {

        this.context = context;
        this.itemsList = itemsList;
        this.skuLayoutBottomBar = skuLayoutBottomBar;
        this.txtCartTotal = txtCartTotal;
    }

    @NonNull
    @Override
    public Recycle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.product_list_adapter,parent,false);
        return new Recycle(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle holder, int position) {
        holder.itemId.setText(itemsList.get(position).getItemId());
        holder.itemName.setText(itemsList.get(position).getName());
        holder.itemMrp.setText(itemsList.get(position).getSalePrice());
    }


    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class Recycle extends RecyclerView.ViewHolder {
        TextView itemId,itemName,itemDescription,itemMrp;
        AppCompatEditText etQnty;
        AppCompatButton btnAdd;
        //Button btnPicking;
        public Recycle(View itemView) {
            super(itemView);
            itemId = (TextView) itemView.findViewById(R.id.itemId);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            itemDescription = (TextView) itemView.findViewById(R.id.itemDescription);
            itemMrp = (TextView) itemView.findViewById(R.id.itemMrp);
            etQnty = (AppCompatEditText) itemView.findViewById(R.id.etQnty);
            btnAdd = (AppCompatButton) itemView.findViewById(R.id.btnAdd);
            btnAdd.setOnClickListener(new View.OnClickListener() {
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
