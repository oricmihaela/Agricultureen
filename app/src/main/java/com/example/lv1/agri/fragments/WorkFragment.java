package com.example.lv1.agri.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lv1.agri.Culture;
import com.example.lv1.agri.Harvest;
import com.example.lv1.agri.MainActivity;
import com.example.lv1.agri.Plant;
import com.example.lv1.agri.R;
import com.example.lv1.agri.RecyclerAdapterHarvesting;
import com.example.lv1.agri.RecyclerAdapterPlanting;
import com.example.lv1.agri.RecyclerViewAdapter;
import com.example.lv1.agri.UserData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WorkFragment extends Fragment {

    TextView textViewPlant ;
    TextView textViewHarvest;
    Button btnAdd;
    EditText etDate;
    EditText etLand;
    RadioButton rbPlanting;
    RadioButton rbHarvesting;

    UserData userData;
    Context context;

    private RecyclerView recyclerViewPlanting;
    private RecyclerAdapterPlanting recyclerAdapterPlanting;
    private List<Plant> planting;

    private RecyclerView recyclerViewHarvesting;
    private RecyclerAdapterHarvesting recyclerAdapterHarvesting;
    private List<Harvest> harvesting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.work_fragment, container, false);
        context = getContext();
        setUpData();

        textViewPlant = (TextView)rootView.findViewById(R.id.tvWorkPlant);
        textViewHarvest = (TextView)rootView.findViewById(R.id.tvWorkHarvest);
        btnAdd = (Button)rootView.findViewById(R.id.btnAddWork);
        etDate = (EditText)rootView.findViewById(R.id.etDate);
        etLand = (EditText)rootView.findViewById(R.id.etLand);
        rbPlanting = (RadioButton)rootView.findViewById(R.id.rbPlanting);
        rbHarvesting = (RadioButton)rootView.findViewById(R.id.rbHarvesting);


        recyclerViewPlanting = rootView.findViewById(R.id.rvPlanting);
        recyclerViewPlanting.setLayoutManager(new LinearLayoutManager(context));

        recyclerAdapterPlanting = new RecyclerAdapterPlanting(planting);
        recyclerViewPlanting.setAdapter(recyclerAdapterPlanting);



        recyclerViewHarvesting = rootView.findViewById(R.id.rvHarvesting);
        recyclerViewHarvesting.setLayoutManager(new LinearLayoutManager(context));

        recyclerAdapterHarvesting = new RecyclerAdapterHarvesting(harvesting);
        recyclerViewHarvesting.setAdapter(recyclerAdapterHarvesting);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbPlanting.isChecked()) {
                    addCellPlanting();
                    return;
                }
                else if(rbHarvesting.isChecked()) {
                    addCellHarvesting();
                    return;
                }
                else {
                    Toast.makeText(context, "Please select planting or harvesting.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

        return rootView;
    }

    private void setUpData() {

        planting = new ArrayList<>();
        harvesting = new ArrayList<>();
    }

    public void addCellPlanting() {
        int position = recyclerAdapterPlanting.getItemCount();
        String land = etLand.getText().toString();
        String date = etDate.getText().toString();
        if(date.isEmpty()) {
            Toast.makeText(context, "Date empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(land.isEmpty()) {
            Toast.makeText(context, "Land empty", Toast.LENGTH_SHORT).show();
            return;
        }
        recyclerAdapterPlanting.addNewCell(date, land, position);
    }

    public void addCellHarvesting() {
        int position = recyclerAdapterHarvesting.getItemCount();
        String date = etDate.getText().toString();
        String land = etLand.getText().toString();
        if(date.isEmpty()) {
            Toast.makeText(context, "Date empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(land.isEmpty()) {
            Toast.makeText(context, "Land empty", Toast.LENGTH_SHORT).show();
            return;
        }
        recyclerAdapterHarvesting.addNewCell(date, land, position);
    }



}
