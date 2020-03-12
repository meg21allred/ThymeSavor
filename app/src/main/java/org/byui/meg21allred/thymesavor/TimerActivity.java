package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TimerActivity extends AppCompatActivity {

    Button mainMenu2Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_timer);

        mainMenu2Btn = (Button) findViewById(R.id.mainMenu2Btn);

    }

    public void mainMenu2(View view) { goToMainMenu2Activity();}

    public void goToMainMenu2Activity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
