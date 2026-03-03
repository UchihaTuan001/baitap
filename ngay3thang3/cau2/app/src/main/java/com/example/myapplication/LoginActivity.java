package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            String user = edtUsername.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            // Kiểm tra để trống
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(LoginActivity.this,
                        "Vui lòng nhập đầy đủ thông tin",
                        Toast.LENGTH_SHORT).show();
            }
            // Kiểm tra đúng tài khoản
            else if (user.equals("admin") && pass.equals("123456")) {

                Toast.makeText(LoginActivity.this,
                        "Đăng nhập thành công",
                        Toast.LENGTH_SHORT).show();

                // Chuyển sang MainActivity
                Intent intent = new Intent(LoginActivity.this,
                        MainActivity.class);
                startActivity(intent);
                finish(); // đóng màn hình login
            }
            // Sai tài khoản
            else {
                Toast.makeText(LoginActivity.this,
                        "Sai tên đăng nhập hoặc mật khẩu",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}