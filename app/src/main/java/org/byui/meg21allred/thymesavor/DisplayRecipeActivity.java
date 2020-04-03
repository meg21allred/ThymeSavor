package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayRecipeActivity extends AppCompatActivity {

    Button startCookingBtn;
    TextView recipeTV;
    NewRecipeActivity newRecipe;
    Intent lastIntent;

    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_recipe);

        startCookingBtn = (Button) findViewById(R.id.startCookingBtn);
        recipeTV = (TextView) findViewById(R.id.recipeTV);

        lastIntent = getIntent();

        if(lastIntent.hasExtra(newRecipe.EXTRA_ID)) {

            String fullRecipe = fullRecipe(lastIntent);
            recipeTV.setText(fullRecipe);
            //fullRecipe(intent);

        }


    }

    public void displaySteps(View view) { startDisplayStepsActivity();}

    public void startDisplayStepsActivity() {
        Intent intent = new Intent(this, DisplaySteps.class);

            ArrayList<String> amount = lastIntent.getStringArrayListExtra(newRecipe.EXTRA_AMOUNT);
            ArrayList<String> ingredient = lastIntent.getStringArrayListExtra(newRecipe.EXTRA_INGREDIENT);
            ArrayList<String> type = lastIntent.getStringArrayListExtra(newRecipe.EXTRA_TYPE);
            ArrayList<String> step = lastIntent.getStringArrayListExtra(newRecipe.EXTRA_STEP);
            String rating = "0";


            intent.putStringArrayListExtra(newRecipe.EXTRA_INGREDIENT, ingredient);
            intent.putStringArrayListExtra(newRecipe.EXTRA_AMOUNT, amount);
            intent.putStringArrayListExtra(newRecipe.EXTRA_TYPE, type);
            intent.putStringArrayListExtra(newRecipe.EXTRA_STEP, step);
            intent.putExtra(newRecipe.EXTRA_RATING,rating);

            startActivity(intent);

    }

    public String fullRecipe(Intent intent) {
        String title = intent.getStringExtra(newRecipe.EXTRA_TITLE);
        ArrayList<String> amount = intent.getStringArrayListExtra(newRecipe.EXTRA_AMOUNT);
        ArrayList<String> ingredient = intent.getStringArrayListExtra(newRecipe.EXTRA_INGREDIENT);
        ArrayList<String> type = intent.getStringArrayListExtra(newRecipe.EXTRA_TYPE);
        ArrayList<String> step = intent.getStringArrayListExtra(newRecipe.EXTRA_STEP);

        String fullRecipe = title + "\n\n\n";
        for (int i = 0; i < ingredient.size(); i++) {
            fullRecipe += amount.get(i) + " " + type.get(i) + " " + ingredient.get(i) + "\n";
        }

        fullRecipe += "\n";

        for (int i = 0; i < step.size(); i++) {
            fullRecipe += (i+1) + ". " + step.get(i) + "\n\n";
        }

        return fullRecipe;
    }

    public String IngredientList(Intent intent) {

        ArrayList<String> amount = intent.getStringArrayListExtra(newRecipe.EXTRA_AMOUNT);
        ArrayList<String> ingredient = intent.getStringArrayListExtra(newRecipe.EXTRA_INGREDIENT);
        ArrayList<String> type = intent.getStringArrayListExtra(newRecipe.EXTRA_TYPE);

        String ingredientList = "";
        for (int i = 0; i < ingredient.size(); i++) {
            ingredientList += amount.get(i) + " " + type.get(i) + " " + ingredient.get(i) + "\n";
        }

        return ingredientList;

    }
}
