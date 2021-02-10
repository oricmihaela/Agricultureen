package com.example.lv1.agri.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv1.agri.MainActivity;
import com.example.lv1.agri.R;


public class LinksFragment extends Fragment {


    TextView croatia;
    TextView serbia;
    TextView bosnia;
    TextView slovenia;
    TextView hungary;
    TextView poland;
    TextView russia;
    TextView uk;
    TextView usa;
    TextView canada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootView = inflater.inflate(
                 R.layout.links_fragment, container, false);


        croatia = (TextView)rootView.findViewById(R.id.tvCroatia);
        croatia.setMovementMethod(LinkMovementMethod.getInstance());
        serbia = (TextView)rootView.findViewById(R.id.tvSerbia);
        serbia.setMovementMethod(LinkMovementMethod.getInstance());
        bosnia = (TextView)rootView.findViewById(R.id.tvBosnia);
        bosnia.setMovementMethod(LinkMovementMethod.getInstance());
        slovenia = (TextView)rootView.findViewById(R.id.tvSlovenia);
        slovenia.setMovementMethod(LinkMovementMethod.getInstance());
        hungary = (TextView)rootView.findViewById(R.id.tvHungary);
        hungary.setMovementMethod(LinkMovementMethod.getInstance());
        poland = (TextView)rootView.findViewById(R.id.tvPoland);
        poland.setMovementMethod(LinkMovementMethod.getInstance());
        russia = (TextView)rootView.findViewById(R.id.tvRussia);
        russia.setMovementMethod(LinkMovementMethod.getInstance());
        uk = (TextView)rootView.findViewById(R.id.tvUk);
        uk.setMovementMethod(LinkMovementMethod.getInstance());
        usa = (TextView)rootView.findViewById(R.id.tvUsa);
        usa.setMovementMethod(LinkMovementMethod.getInstance());
        canada = (TextView)rootView.findViewById(R.id.tvCanada);
        canada.setMovementMethod(LinkMovementMethod.getInstance());

        return rootView;
    }


}
