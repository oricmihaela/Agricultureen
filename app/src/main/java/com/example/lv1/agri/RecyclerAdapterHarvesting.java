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

public class RecyclerAdapterHarvesting extends RecyclerView.Adapter<RecyclerAdapterHarvesting.NameViewHolder> {

    private List<Harvest> harvesting = new ArrayList<>();

    public RecyclerAdapterHarvesting(List<Harvest> harvesting) {
        this.harvesting = harvesting;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_work_harvest, parent, false);
        return new NameViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterHarvesting.NameViewHolder holder, int position) {
        String date = harvesting.get(position).getDate();
        String land = harvesting.get(position).getLand();

        holder.dateTextView.setText(date);
        holder.landTextView.setText(land);
    }

    @Override
    public int getItemCount() {
        return harvesting.size();
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
        Harvest newHarvest = new Harvest(date, land);
        harvesting.add(position, newHarvest);
        notifyItemInserted(position);
    }

    public void removeCell(int position) {
        if(harvesting.size() >= position) {
            harvesting.remove(position);
            notifyItemRemoved(position);
        }
    }

}
