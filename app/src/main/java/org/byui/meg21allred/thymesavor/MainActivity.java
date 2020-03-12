package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button enterNewRecipeBtn;
    Button loadReciptBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        enterNewRecipeBtn = (Button) findViewById(R.id.enterNewRecipeBtn);
        loadReciptBtn = (Button) findViewById(R.id.loadRecipeBtn);
    }

    public void newRecipe(View v) {
        openNewRecipeActivity();
    }

    public void openNewRecipeActivity() {
        Intent intent = new Intent(this, NewRecipeActivity.class);
        startActivity(intent);

    }

    public void loadRecipe(View v) {loadRecipeActivity();}

    public void loadRecipeActivity() {
        Intent intent = new Intent(this, SearchRecipes.class);
        startActivity(intent);
    }
}
