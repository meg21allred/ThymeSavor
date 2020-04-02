package org.byui.meg21allred.thymesavor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {

    private EditText enterRateEt;
    int rating;

    private RecipeViewModel recipeViewModel;
    public static final int EDIT_RECIPE_ACTIVITY_REQUEST_CODE = 2;

    private Button enterRateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_rating);

        enterRateEt = (EditText) findViewById(R.id.enterRateET);
        rating = 0;
        enterRateBtn = (Button) findViewById(R.id.enterRateBtn);


        final Button enterRateBtn = findViewById(R.id.enterRateBtn);
        enterRateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent replyIntent = getIntent();
                if (TextUtils.isEmpty(enterRateEt.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String rating = enterRateEt.getText().toString();
                    //same format for the rest of the edit texts

                    // get activity information into another activity-- not by passing an intent
                    // maybe by updating it
                   // recipe.setRating(enterRateEt.getText().toString());

                    // this will start the train of passing rate back to the Recipe
                    //FinishRecipe FR = new FinishRecipe();
                  //  FR.setRating(rating);



                //    int id = getIntent().getIntExtra(EXTRA_ID, -1);
               //    if (id != -1) {
                //        replyIntent.putExtra(EXTRA_ID, id);
                   // }
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });



    }

    public void setRating() {
        rating = Integer.valueOf(enterRateEt.getText().toString());
    }


    public void clearMessage(View view) {
        enterRateEt.setText("");
    }

    public void goBack(View view) {goToLastActivity();}

    public void goToLastActivity() {
        Intent intent = new Intent (this, FinishRecipe.class);
        startActivity(intent);
    }



}
