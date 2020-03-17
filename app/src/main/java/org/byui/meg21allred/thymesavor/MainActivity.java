package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

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
