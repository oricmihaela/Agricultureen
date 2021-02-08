package com.example.lv1.agri.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv1.agri.MainActivity;
import com.example.lv1.agri.R;
import com.example.lv1.agri.UserData;



public class WorkFragment extends Fragment {

    TextView textView ;

    UserData userData;

    Button logOut;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.work_fragment, container, false);
        textView = (TextView)rootView.findViewById(R.id.tvWork);
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            userData = (UserData)bundle.getParcelable("key");
        }
        else{
            Toast.makeText(getContext(), "null", Toast.LENGTH_LONG).show();
        }
        if(userData != null) {
            textView.setText(userData.getMail());
        }
        else{
            Toast.makeText(getContext(), "null", Toast.LENGTH_LONG).show();
        }

        this.logOut = (Button)rootView.findViewById(R.id.btnLogOutWork);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
