package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class FinishRecipe extends AppCompatActivity {

    Button mainMenuBtn;
    Button timerBtn;
    Button ratingBtn;
    NewRecipeActivity newRecipe;
    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_finish_recipe);

        mainMenuBtn = (Button) findViewById(R.id.mainMenuBtn);
        timerBtn = (Button) findViewById(R.id.timerBtn);
        ratingBtn = (Button) findViewById(R.id.ratingBtn);

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

    public void ratingBtn(View view) {goToRatingActivity();}

    public void goToRatingActivity() {
        Intent intent = new Intent(this, RatingActivity.class);
        String rating = "2";
        //recipe.setRating(rating);


        intent.putExtra(newRecipe.EXTRA_RATING,rating);
        startActivity(intent);
    }

}
