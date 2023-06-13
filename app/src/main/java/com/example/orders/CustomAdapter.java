package com.example.orders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    ArrayList<String> stockname;
    ArrayList<String> network;
    Context context;

    public CustomAdapter(ArrayList<String> stockname, ArrayList<String> network, Context context) {
        this.stockname = stockname;
        this.network = network;
        this.context = context;
    }

    public CustomAdapter(Context context, ArrayList<String> stockname, ArrayList<String> network) {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        MyViewHolder viewholder = new MyViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.stockname.setText(stockname.get(position));
        holder.network.setText(network.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,stockname.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView stockname,network;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            stockname = itemView.findViewById(R.id.stockname);
            network = itemView.findViewById(R.id.network);

        }
    }

}
