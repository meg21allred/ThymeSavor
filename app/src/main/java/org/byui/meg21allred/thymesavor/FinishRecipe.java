package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;

public class FinishRecipe extends AppCompatActivity {

    Button mainMenuBtn;
    Button timerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_finish_recipe);

        mainMenuBtn = (Button) findViewById(R.id.mainMenuBtn);
        timerBtn = (Button) findViewById(R.id.timerBtn);
    }

    public void mainMenu(View view) {goToMainActivity();}

    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void timerBtn(View view) {goToTimerActivity();}

    public void goToTimerActivity() {
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }

}
