package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class SearchRecipes extends AppCompatActivity {

    Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_search_recipes);

        searchBtn = (Button) findViewById(R.id.searchBtn);

    }


    public void searchRecipes(View view) { searchRecipesActivity();}

    public void searchRecipesActivity() {
        Intent intent = new Intent(this, DisplayRecipeActivity.class);
        startActivity(intent);
    }


}
