package com.suharev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class Registration extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button;
    TextView textView;
    HashMap<String, String> personData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initializationWidgets();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editText1.getText().toString();
                String password1 = editText2.getText().toString();
                String password2 = editText3.getText().toString();
                if (password1.equals(password2)) {
                    if (!personData.containsKey(text1)) {
                        personData.put(text1, password1);
                        Intent intent = new Intent(Registration.this, MainActivity.class);
                        intent.putExtra("login", text1);
                        intent.putExtra("password", password1);
                        startActivity(intent);
                    } else {
                        textView.setText("Данный логин занят");
                    }
                } else {
                    textView.setText("Пароли различны");
                }
            }
        });
    }
    private void initializationWidgets() {
        editText1 = (EditText) findViewById(R.id.edit_text1);
        editText2 = (EditText) findViewById(R.id.edit_text2);
        editText3 = (EditText) findViewById(R.id.edit_text3);
        textView = (TextView) findViewById(R.id.problems);
        button = (Button) findViewById(R.id.button);
        personData = MocDataBase.personData;
    }
}