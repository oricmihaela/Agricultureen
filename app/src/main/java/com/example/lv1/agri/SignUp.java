package com.example.lv1.agri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    TextView mTvAppNameRegister;
    EditText mEtMailRegister;
    EditText mEtPasswordRegister;
    Button mBtnRegister;

    String mail;
    String password;

    BaseAdapter baseAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        initializeUI();

        baseAdapter = new BaseAdapter(this);
    }

    private void initializeUI() {

        mTvAppNameRegister = (TextView)findViewById(R.id.tvAppNameRegister);
        mEtMailRegister = (EditText)findViewById(R.id.etMailRegister);
        mEtPasswordRegister = (EditText)findViewById(R.id.etPasswordRegister);
        mBtnRegister = (Button)findViewById(R.id.btnRegister);


        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = mEtMailRegister.getText().toString();
                password = mEtPasswordRegister.getText().toString();
                if(mail == null) {
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Insert valid mail.", Toast.LENGTH_LONG);
                    return;
                }
                baseAdapter.insertUser(mail, password);
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
