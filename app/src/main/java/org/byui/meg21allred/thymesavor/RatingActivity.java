package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class RatingActivity extends AppCompatActivity {

    private EditText enterRateEt;
    NewRecipeActivity newRecipe;
    Button ratingBtn;
    Recipe recipe;
    private String rating;

    //private RecipeViewModel recipeViewModel;
    //public static final int EDIT_RECIPE_ACTIVITY_REQUEST_CODE = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_rating);

        enterRateEt = (EditText) findViewById(R.id.enterRateET);
        ratingBtn = (Button) findViewById(R.id.button);
        Intent intent = getIntent();

        if(intent.hasExtra(newRecipe.EXTRA_RATING)) {
            enterRateEt.setText(intent.getStringExtra(newRecipe.EXTRA_RATING));

        }
        ratingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ratingIntent = new Intent(RatingActivity.this, AddRecipeRoom.class);
                rating = enterRateEt.getText().toString();
                ratingIntent.putExtra(newRecipe.EXTRA_RATING, rating);
                setResult(RESULT_OK, ratingIntent);//trying to set the rating here but doesn't seem to be working
                startActivity(ratingIntent);


            }
        });



    }

    /*public void clearMessage(View view) {
        enterRateEt.setText("");
    }

    public void goBack(View view) {goToLastActivity();}

    public void goToLastActivity() {
        Intent intent = new Intent (this, FinishRecipe.class);
        startActivity(intent);
    }*/


}
