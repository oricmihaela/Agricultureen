package com.example.lv1.agri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NameViewHolder> {

    private List<Culture> cultures = new ArrayList<>();

    public RecyclerViewAdapter(List<Culture> cultures) {
        this.cultures = cultures;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_cell_, parent, false);
        return new NameViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        String name = cultures.get(position).getName();
        String price = cultures.get(position).getPrice();

        holder.cultureTextView.setText(name);
        holder.priceTextView.setText(price);
    }

    @Override
    public int getItemCount() {
        return cultures.size();
    }


    public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView cultureTextView;
        private final TextView priceTextView;
        private Button button;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            this.button = itemView.findViewById(R.id.btnRemove);
            cultureTextView =itemView.findViewById(R.id.tvCulture);
            priceTextView = itemView.findViewById(R.id.tvPrice);

            this.button.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            removeCell(position);
        }
    }
    public void addNewCell(String culture, String price, int position) {
        if(cultures.size() >= position) {
            Culture newCulture = new Culture(culture, price);
            cultures.add(position, newCulture);
            notifyItemInserted(position);
        }
    }

    public void removeCell(int position) {
        if(cultures.size() >= position) {
            cultures.remove(position);
            notifyItemRemoved(position);
        }
    }

}
