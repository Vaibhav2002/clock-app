package com.example.clock;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

public class StopwatchFragment extends Fragment {
    Chronometer chronometer;
    Button start, pause, reset;
    boolean running;
    long pauseoffset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        chronometer = view.findViewById(R.id.chronometer2);
        start = view.findViewById(R.id.stopwatch_start);
        pause = view.findViewById(R.id.stopwatch_pause);
        reset = view.findViewById(R.id.stopwatch_reset);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!running) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
                    chronometer.start();
                    running = true;
                    start.setVisibility(View.GONE);
                    pause.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.GONE);
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running) {
                    chronometer.stop();
                    pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    running = false;
                    pause.setVisibility(View.GONE);
                    start.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseoffset = 0;
                reset.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
            }
        });

        return view;

    }
}