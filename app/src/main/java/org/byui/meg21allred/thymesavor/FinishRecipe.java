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
import android.widget.Toast;

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

    public void ratingBtn(View view) {goToRecyclerView();}

    // have the rating button send back to the recycler view
    public void goToRecyclerView() {
        Intent intent = new Intent(this, AddRecipeRoom.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(),"Pick a Recipe to Rate",Toast.LENGTH_LONG).show();
    }

}
