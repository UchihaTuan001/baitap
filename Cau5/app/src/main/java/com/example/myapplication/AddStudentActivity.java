package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    Button btnLuu, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        btnLuu = findViewById(R.id.btnLuu);
        btnHuy = findViewById(R.id.btnHuy);

        btnHuy.setOnClickListener(v -> finish());
        btnLuu.setOnClickListener(v -> finish());
    }
}