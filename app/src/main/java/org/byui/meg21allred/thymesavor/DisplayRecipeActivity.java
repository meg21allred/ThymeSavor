package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//This recipe is takes all the data from the room database to display all the parts of the recipe in one place
public class DisplayRecipeActivity extends AppCompatActivity {

    Button startCookingBtn;
    TextView recipeTV;
    NewRecipeActivity newRecipe;
    Intent lastIntent;

    Button addImageBtn;
    ImageView imageView;

    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_recipe);

        startCookingBtn = (Button) findViewById(R.id.startCookingBtn);
        recipeTV = (TextView) findViewById(R.id.recipeTV);

        //get the data from the last activity
        lastIntent = getIntent();

        if(lastIntent.hasExtra(newRecipe.EXTRA_ID)) {

            String fullRecipe = fullRecipe(lastIntent);
            recipeTV.setText(fullRecipe);
            //fullRecipe(intent);

        }

        addImageBtn = (Button) findViewById(R.id.addImageBtn);
        imageView = (ImageView) findViewById(R.id.recipeImageIV);

        addImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    public void displaySteps(View view) { startDisplayStepsActivity();}

    //sends recipe data to the next activity and starts the next activity
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
    //This function is used to add all the recipe data together and display it in one Text view
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

    //this function displays just the list of ingredients
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
