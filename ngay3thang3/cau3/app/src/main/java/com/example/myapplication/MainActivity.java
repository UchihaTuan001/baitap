package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new MyAdapter());

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0)
                        tab.setText("C → F");
                    else
                        tab.setText("F → C");
                }).attach();
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view;
            if (viewType == 0) {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_tab1, parent, false);
            } else {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_tab2, parent, false);
            }
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            if (position == 0) {
                EditText edtC = holder.itemView.findViewById(R.id.edtC);
                Button btnTinh = holder.itemView.findViewById(R.id.btnTinhC);
                Button btnXoa = holder.itemView.findViewById(R.id.btnXoaC);
                TextView txtKq = holder.itemView.findViewById(R.id.txtKqC);

                btnTinh.setOnClickListener(v -> {
                    if (edtC.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this,
                                "Vui lòng nhập dữ liệu",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        double c = Double.parseDouble(edtC.getText().toString());
                        double f = c * 1.8 + 32;
                        txtKq.setText("Kết quả: " +
                                String.format("%.2f", f) + " °F");
                    }
                });

                btnXoa.setOnClickListener(v -> {
                    edtC.setText("");
                    txtKq.setText("");
                });

            } else {
                EditText edtF = holder.itemView.findViewById(R.id.edtF);
                Button btnTinh = holder.itemView.findViewById(R.id.btnTinhF);
                Button btnXoa = holder.itemView.findViewById(R.id.btnXoaF);
                TextView txtKq = holder.itemView.findViewById(R.id.txtKqF);

                btnTinh.setOnClickListener(v -> {
                    if (edtF.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this,
                                "Vui lòng nhập dữ liệu",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        double f = Double.parseDouble(edtF.getText().toString());
                        double c = (f - 32) / 1.8;
                        txtKq.setText("Kết quả: " +
                                String.format("%.2f", c) + " °C");
                    }
                });

                btnXoa.setOnClickListener(v -> {
                    edtF.setText("");
                    txtKq.setText("");
                });
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}