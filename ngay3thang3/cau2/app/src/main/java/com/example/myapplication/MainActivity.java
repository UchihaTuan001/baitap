package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText edtToan, edtVan, edtAnh;
    Button btnTinh, btnHienThi, btnXoa;
    TextView txtKetQua;

    double diemTrungBinh = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtToan = findViewById(R.id.edtToan);
        edtVan = findViewById(R.id.edtVan);
        edtAnh = findViewById(R.id.edtAnh);

        btnTinh = findViewById(R.id.btnTinh);
        btnHienThi = findViewById(R.id.btnHienThi);
        btnXoa = findViewById(R.id.btnXoa);

        txtKetQua = findViewById(R.id.txtKetQua);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhDiem();
            }
        });

        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienThiKetQua();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoaDuLieu();
            }
        });
    }

    private void tinhDiem() {
        try {
            double toan = Double.parseDouble(edtToan.getText().toString());
            double van = Double.parseDouble(edtVan.getText().toString());
            double anh = Double.parseDouble(edtAnh.getText().toString());

            if (toan < 0 || toan > 10 ||
                    van < 0 || van > 10 ||
                    anh < 0 || anh > 10) {

                Toast.makeText(this,
                        "Điểm không hợp lệ (0–10)",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            diemTrungBinh = (toan + van + anh) / 3;

            Toast.makeText(this,
                    "Đã tính xong!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this,
                    "Vui lòng nhập đầy đủ điểm!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void hienThiKetQua() {
        if (diemTrungBinh < 0) {
            Toast.makeText(this,
                    "Bạn chưa tính điểm!",
                    Toast.LENGTH_SHORT).show();
        } else {
            txtKetQua.setText("Điểm trung bình: " +
                    String.format("%.2f", diemTrungBinh));
        }
    }

    private void xoaDuLieu() {
        edtToan.setText("");
        edtVan.setText("");
        edtAnh.setText("");
        txtKetQua.setText("");
        diemTrungBinh = -1;
    }
}