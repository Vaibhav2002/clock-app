package com.example.clock;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

public class TimerFragment extends Fragment {
    EditText min, sec;
    LottieAnimationView checkbox, playpause, stop;
    TextView time;
    long timeleftinmilli, STARTTIME;
    boolean isrunning = false;
    CountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        min = view.findViewById(R.id.min);
        time = view.findViewById(R.id.timedisp);
        sec = view.findViewById(R.id.sec);
        checkbox = view.findViewById(R.id.checkboxbutton);
        playpause = view.findViewById(R.id.playpausebutton);
        stop = view.findViewById(R.id.stopbutton);
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int minutes = Integer.parseInt(min.getText().toString());
                int seconds = Integer.parseInt(sec.getText().toString());
                timeleftinmilli = (minutes * 60 + seconds) * 1000;
                STARTTIME = timeleftinmilli;
                updateTimer();
                checkbox.playAnimation();
            }
        });

        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isrunning)
                    pauseTimer();
                else
                    startTimer();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }

        });
        updateTimer();
        return view;
    }


    void startTimer() {
        playpause.setSpeed(1);
        playpause.playAnimation();
        stop.setVisibility(View.INVISIBLE);
        countDownTimer = new CountDownTimer(timeleftinmilli, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmilli = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                isrunning = false;
                updateTimer();
            }
        }.start();
        isrunning = true;
    }

    void pauseTimer() {
        countDownTimer.cancel();
        isrunning = false;
        playpause.setSpeed(-2);
        playpause.playAnimation();
        stop.setVisibility(View.VISIBLE);
    }

    void stopTimer() {
        stop.playAnimation();
        timeleftinmilli = STARTTIME;
        updateTimer();
        stop.setVisibility(View.INVISIBLE);

    }

    void updateTimer() {
        int min = (int) ((timeleftinmilli / 1000) / 60);
        int sec = (int) ((timeleftinmilli / 1000) % 60);
        String disptime = String.format("%02d:%02d", min, sec);
        time.setText(disptime);

    }
}