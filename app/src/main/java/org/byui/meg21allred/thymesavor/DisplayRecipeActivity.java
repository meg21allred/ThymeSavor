package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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

            String fullRecipe = fullRecipe(intent);
            recipeTV.setText(fullRecipe);

        }


    }

    public void displaySteps(View view) { startDisplayStepsActivity();}

    public void startDisplayStepsActivity() {
        Intent intent = new Intent(this, DisplaySteps.class);
        startActivity(intent);
    }

    public String fullRecipe(Intent intent) {
        String fullRecipe;
        String title = intent.getStringExtra(newRecipe.EXTRA_TITLE);
        String amount = intent.getStringExtra(newRecipe.EXTRA_AMOUNT);
        ArrayList<String> ingredient = intent.getStringArrayListExtra(newRecipe.EXTRA_INGREDIENT);
        //ArrayList<String> ingredient = new ArrayList<>();
        //String ingredient = intent.getStringExtra(newRecipe.EXTRA_INGREDIENT);
        String type = intent.getStringExtra(newRecipe.EXTRA_TYPE);
        String step = intent.getStringExtra(newRecipe.EXTRA_STEP);

        fullRecipe = title + "\n\n" + amount + " " + type + " " + ingredient + "\n\n" + step;
        //fullRecipe = "Mac and Cheese";

        return fullRecipe;
    }
}
