package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

//This class is creates an Activity with a timer ability
public class TimerActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 1500000;

    private EditText enterTimeEt;
    private Button mainMenu2Btn;
    private Button startBtn;
    private TextView counterTV;
    private Button pauseBtn;
    private Button resetBtn;
    int minutes;

    private CountDownTimer countDownTimer;

    private boolean timerRunning = false;

    private long mTimeleftInMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_timer);

        mainMenu2Btn = (Button) findViewById(R.id.mainMenu2Btn);
        enterTimeEt = (EditText) findViewById(R.id.enterTimeET);
        startBtn = (Button) findViewById(R.id.startBtn);
        counterTV = (TextView) findViewById(R.id.counterTV);
        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);

    }

    public void mainMenu2(View view) { goToMainMenu2Activity();}

    //return to the main menu
    public void goToMainMenu2Activity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //reset the timer
    public void resetTimer(View view) {
        mTimeleftInMillis = (Integer.valueOf(enterTimeEt.getText().toString())) * 60000;
        updateCountDownText();
    }

    //pause the timer
    public void pauseTimer(View view) {
        countDownTimer.cancel();
        timerRunning = false;
    }

    //Start the timer
    public void startTimer(View view) {

        minutes = Integer.valueOf(enterTimeEt.getText().toString());
        mTimeleftInMillis = minutes * 60000;

        countDownTimer = new CountDownTimer(mTimeleftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeleftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

                timerRunning = false;
            }
        }.start();

        timerRunning = true;

        updateCountDownText();
    }

    //update the timer
    private void updateCountDownText() {
        int minutes = (int) (mTimeleftInMillis / 1000) / 60;
        int seconds = (int) (mTimeleftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        counterTV.setText(timeLeftFormatted);
    }

    public void clearMessage(View view) {
        enterTimeEt.setText("");
    }
}
