package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DisplayRecipeActivity extends AppCompatActivity {

    Button startCookingBtn;
    TextView recipeTV;
    NewRecipeActivity newRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_recipe);

        startCookingBtn = (Button) findViewById(R.id.startCookingBtn);
        recipeTV = (TextView) findViewById(R.id.recipeTV);

        Intent intent = getIntent();

        if(intent.hasExtra(newRecipe.EXTRA_ID)) {
            recipeTV.setText(intent.getStringExtra(newRecipe.EXTRA_TITLE));

        }


    }

    public void displaySteps(View view) { startDisplayStepsActivity();}

    public void startDisplayStepsActivity() {
        Intent intent = new Intent(this, DisplaySteps.class);
        startActivity(intent);
    }
}
