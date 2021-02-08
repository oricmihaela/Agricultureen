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

    Button logOut;

    TextView croatia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootView = inflater.inflate(
                 R.layout.links_fragment, container, false);

        this.logOut = (Button)rootView.findViewById(R.id.btnLogOutLinks);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        croatia = (TextView)rootView.findViewById(R.id.tvCroatia);
        croatia.setMovementMethod(LinkMovementMethod.getInstance());

        return rootView;
    }


}
