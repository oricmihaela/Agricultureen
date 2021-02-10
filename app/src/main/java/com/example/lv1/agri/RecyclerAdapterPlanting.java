package com.example.lv1.agri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecyclerAdapterPlanting extends RecyclerView.Adapter<RecyclerAdapterPlanting.NameViewHolder> {

    private List<Plant> planting = new ArrayList<>();

    public RecyclerAdapterPlanting(List<Plant> planting) {
        this.planting = planting;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_work, parent, false);
        return new NameViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterPlanting.NameViewHolder holder, int position) {
        String date = planting.get(position).getDate();
        String land = planting.get(position).getLand();

        holder.dateTextView.setText(date);
        holder.landTextView.setText(land);
    }

    @Override
    public int getItemCount() {
        return planting.size();
    }


    public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView dateTextView;
        private final TextView landTextView;
        private Button button;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            this.button = itemView.findViewById(R.id.btnRemoveWork);
            dateTextView =itemView.findViewById(R.id.tvDate);
            landTextView = itemView.findViewById(R.id.tvLand);

            this.button.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            removeCell(position);
        }
    }
    public void addNewCell(String date, String land, int position) {
        if(planting.size() >= position) {
            Plant newPlant = new Plant(date, land);
            planting.add(position, newPlant);
            notifyItemInserted(position);
        }
    }

    public void removeCell(int position) {
        if(planting.size() >= position) {
            planting.remove(position);
            notifyItemRemoved(position);
        }
    }

}
