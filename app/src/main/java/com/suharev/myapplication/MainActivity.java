package com.suharev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText login, password;
    Button logIn;
    TextView status;
    HashMap<String, String> personData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializationWidgets();
        if (getIntent().hasExtra("login") && getIntent().hasExtra("password")) {
            login.setText(getIntent().getStringExtra("login"));
            password.setText(getIntent().getStringExtra("password"));
        }
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (personData.containsKey(login.getText().toString()) && personData.get(login.getText().toString()).equals(password.getText().toString())) {
                    status.setText("Все окей");
                } else {
                    Intent intent = new Intent(MainActivity.this, Registration.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void initializationWidgets() {
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        logIn = (Button) findViewById(R.id.log_in);
        status = (TextView) findViewById(R.id.status);
        personData = MocDataBase.personData;
    }
}