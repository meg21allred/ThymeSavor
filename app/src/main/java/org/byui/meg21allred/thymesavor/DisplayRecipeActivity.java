package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class DisplayRecipeActivity extends AppCompatActivity {

    Button startCookingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_recipe);

        startCookingBtn = (Button) findViewById(R.id.startCookingBtn);
    }

    public void displaySteps(View view) { startDisplayStepsActivity();}

    public void startDisplayStepsActivity() {
        Intent intent = new Intent(this, DisplaySteps.class);
        startActivity(intent);
    }
}
