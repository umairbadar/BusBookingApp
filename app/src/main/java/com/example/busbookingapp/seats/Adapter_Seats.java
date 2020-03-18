package com.example.busbookingapp.seats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.busbookingapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class Adapter_Seats extends RecyclerView.Adapter<Adapter_Seats.ViewHolder> {

    private List<Model_Seats> list;
    private String selected_seats = "";

    public Adapter_Seats(List<Model_Seats> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_seats, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final Model_Seats item = list.get(position);

        holder.tv_seat_no.setText(item.getSeat_no());

        holder.img_seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.img_seat.getDrawable().getConstantState() == view.getContext().getResources().getDrawable(R.drawable.ic_bus_seat_black).getConstantState()) {

                    holder.img_seat.setImageResource(R.drawable.ic_bus_seat_green);
                } else {

                    holder.img_seat.setImageResource(R.drawable.ic_bus_seat_black);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_seat_no;
        ImageButton img_seat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_seat_no = itemView.findViewById(R.id.tv_seat_no);
            img_seat = itemView.findViewById(R.id.img_seat);
        }
    }
}
