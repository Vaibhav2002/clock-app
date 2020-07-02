package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
        chip.setItemSelected(R.id.nav_stopwatch,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new StopwatchFragment()).commit();
        chip.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment frag=null;
                switch (i)
                {
                    case R.id.nav_stopwatch:
                        frag=new StopwatchFragment();
                        break;
                    case R.id.nav_timer:
                        frag=new TimerFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,frag).commit();
            }
        });
    }
}