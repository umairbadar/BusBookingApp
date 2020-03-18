package com.example.busbookingapp.Bus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.busbookingapp.R;
import com.example.busbookingapp.seats.SeatsActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class Adapter_Bus extends RecyclerView.Adapter<Adapter_Bus.ViewHolder> {

    private List<Model_Bus> list;
    private Context context;

    public Adapter_Bus(List<Model_Bus> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bus_layout, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final Model_Bus item = list.get(position);

        holder.tv_bus_name.setText(item.getBus_name());
        holder.tv_bus_desc.setText(item.getBus_desc());
        holder.tv_arrival_time.setText(item.getBus_arrival_time());
        holder.tv_reach_time.setText(item.getBus_reach_time());
        holder.tv_bus_ticket_price.setText(item.getBus_ticket_price());
        holder.tv_total_seats.setText(item.getBus_total_seats());

        holder.root_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), SeatsActivity.class);
                intent.putExtra("location", BusActivity.tv_toolbar_text.getText().toString());
                intent.putExtra("bus_name", item.getBus_name());
                intent.putExtra("bus_desc", item.getBus_desc());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_bus_name, tv_bus_desc, tv_arrival_time, tv_reach_time, tv_bus_ticket_price, tv_total_seats;
        RelativeLayout root_Layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_bus_name = itemView.findViewById(R.id.tv_bus_name);
            tv_bus_desc = itemView.findViewById(R.id.tv_bus_desc);
            tv_arrival_time = itemView.findViewById(R.id.tv_arrival_time);
            tv_reach_time = itemView.findViewById(R.id.tv_reach_time);
            tv_bus_ticket_price = itemView.findViewById(R.id.tv_bus_ticket_price);
            tv_total_seats = itemView.findViewById(R.id.tv_total_seats);

            root_Layout = itemView.findViewById(R.id.root_Layout);
        }
    }
}
