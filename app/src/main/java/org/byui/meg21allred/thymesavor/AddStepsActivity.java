package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class AddStepsActivity extends AppCompatActivity {

    Button finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_steps);

        finishBtn = (Button) findViewById(R.id.finishBtn);
    }

    public void displayRecipe(View v) {
        openDisplayRecipe();
    }

    public void openDisplayRecipe() {
        Intent intent = new Intent(this, DisplayRecipeActivity.class);
        startActivity(intent);

    }
}
