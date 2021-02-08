package com.example.lv1.agri.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lv1.agri.Culture;
import com.example.lv1.agri.MainActivity;
import com.example.lv1.agri.R;
import com.example.lv1.agri.RecyclerViewAdapter;
import com.example.lv1.agri.SignUp;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class EarningsFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Culture> cultures;

    Context context;

    //calculator
    EditText editTextAreaCalculator;
    EditText editTextPriceCalculator;
    TextView textViewResultCalculator;
    Button buttonCalculate;

    //recycler
    Button btnRemove;
    Button btnAdd;
    EditText editTextName;
    EditText editTextPrice;

    Button logOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.earnings_fragment, container, false);
        setUpData();

        this.logOut = (Button)rootView.findViewById(R.id.btnLogOutEarnings);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        this.editTextAreaCalculator = (EditText)rootView.findViewById(R.id.etAreaCalculator);
        this.editTextPriceCalculator = (EditText)rootView.findViewById(R.id.etPiceCalculator);
        this.textViewResultCalculator = (TextView)rootView.findViewById(R.id.tvResultCalculator);
        this.buttonCalculate = (Button)rootView.findViewById(R.id.btnCalculate);
        this.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double area = parseDouble(editTextAreaCalculator.getText().toString());
                Double price = parseDouble(editTextPriceCalculator.getText().toString());

                String message = "Estimated earnings on this culture: ";
                message += area*price;
                textViewResultCalculator.setText(message);
            }
        });

        this.editTextName = (EditText)rootView.findViewById(R.id.etInsertNew);
        this.editTextPrice = (EditText)rootView.findViewById(R.id.etInsertPrice);
        this.btnAdd = (Button)rootView.findViewById(R.id.btnAdd);
        this.btnRemove = (Button)rootView.findViewById(R.id.btnRemove);

        recyclerView = rootView.findViewById(R.id.rvCultures);
        context = container.getContext();

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        recyclerViewAdapter = new RecyclerViewAdapter(cultures);
        recyclerView.setAdapter(recyclerViewAdapter);

        btnAdd.setOnClickListener(this);
        return rootView;
    }

    private void setUpData() {
        cultures = new ArrayList<>();
    }

    public void addCell() {
        int position = recyclerViewAdapter.getItemCount();
        String name = editTextName.getText().toString();
        String price = editTextPrice.getText().toString();
        if(name.isEmpty()) {
            Toast.makeText(context, "Culture name empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(price.isEmpty()) {
            Toast.makeText(context, "Culture price empty", Toast.LENGTH_SHORT).show();
            return;
        }
        recyclerViewAdapter.addNewCell(name, price, position);
    }

    @Override
    public void onClick(View v) {
        addCell();
    }
}
