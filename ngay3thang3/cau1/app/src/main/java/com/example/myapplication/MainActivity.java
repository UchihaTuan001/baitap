package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1, edtSo2;
    TextView txtKetQua;
    Button btnCong, btnTru, btnNhan, btnChia, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnClear = findViewById(R.id.btnClear);

        btnCong.setOnClickListener(v -> tinhToan("+"));
        btnTru.setOnClickListener(v -> tinhToan("-"));
        btnNhan.setOnClickListener(v -> tinhToan("*"));
        btnChia.setOnClickListener(v -> tinhToan("/"));

        btnClear.setOnClickListener(v -> {
            edtSo1.setText("");
            edtSo2.setText("");
            txtKetQua.setText("Kết quả: ");
        });
    }

    private void tinhToan(String phepToan) {
        String so1Str = edtSo1.getText().toString();
        String so2Str = edtSo2.getText().toString();

        if (so1Str.isEmpty() || so2Str.isEmpty()) {
            txtKetQua.setText("Vui lòng nhập đủ số");
            return;
        }

        double so1 = Double.parseDouble(so1Str);
        double so2 = Double.parseDouble(so2Str);
        double ketQua = 0;

        switch (phepToan) {
            case "+":
                ketQua = so1 + so2;
                break;
            case "-":
                ketQua = so1 - so2;
                break;
            case "*":
                ketQua = so1 * so2;
                break;
            case "/":
                if (so2 == 0) {
                    txtKetQua.setText("Không thể chia cho 0");
                    return;
                }
                ketQua = so1 / so2;
                break;
        }

        txtKetQua.setText("Kết quả: " + ketQua);
    }
}