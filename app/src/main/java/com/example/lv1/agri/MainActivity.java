package com.example.lv1.agri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mTvAppNameLogin;
    EditText mEtMailLogin;
    EditText mEtPasswordLogin;
    Button mBtnLogin;
    TextView mTvNewUser;

    String mail1;
    String password1;

    BaseAdapter baseAdapter;
    UserData userData;

    String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvAppNameLogin = (TextView)findViewById(R.id.tvAppNameLogin);
        mEtMailLogin = (EditText)findViewById(R.id.etMailLogin);
        mEtPasswordLogin = (EditText)findViewById(R.id.etPasswordLogin);
        mBtnLogin = (Button)findViewById(R.id.btnLogin);
        mTvNewUser = (TextView)findViewById(R.id.tvNewUser);


        baseAdapter = new BaseAdapter(this);

        mTvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail1 = mEtMailLogin.getText().toString();
                password1 = mEtPasswordLogin.getText().toString();

                userData = baseAdapter.getUser(mail1);
                password2 = userData.getPassword();
                //Toast.makeText(getBaseContext(), password1,Toast.LENGTH_LONG).show();
                if(password1.equals(password2)) {
                    Intent intent = new Intent(MainActivity.this, ContentPage.class);
                    startActivity(intent);
                }
                else
                Toast.makeText(getBaseContext(), "Wrong password.", Toast.LENGTH_LONG).show();
            }
        });
    }
}