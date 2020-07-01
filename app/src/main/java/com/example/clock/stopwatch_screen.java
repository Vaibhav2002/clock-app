package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class stopwatch_screen extends AppCompatActivity {
    ChipNavigationBar chip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch_screen);
        chip=findViewById(R.id.chipnavi);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new stopwatchfrag()).commit();
        chip.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

            }
        });
    }
}