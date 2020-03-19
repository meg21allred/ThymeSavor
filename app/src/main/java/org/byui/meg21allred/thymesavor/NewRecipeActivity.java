package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class NewRecipeActivity extends AppCompatActivity {

    private AddIngredientsViewModel addIngredientsViewModel;

    Button addStepsActitivyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_recipe);

        addIngredientsViewModel = new ViewModelProvider(this).get(AddIngredientsViewModel.class);
        addIngredientsViewModel.getAllIngredients().observe(this, new Observer<List<AddIngredients>>() {
            @Override
            public void onChanged(List<AddIngredients> addIngredients) {
                //update recyclerView
                Toast.makeText(NewRecipeActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });

        addStepsActitivyBtn = (Button) findViewById(R.id.addStepsActivityBtn);
    }

    public void addSteps(View v) {
        openAddStepsActivity();
    }

    public void openAddStepsActivity() {
        Intent intent = new Intent(this, AddStepsActivity.class);
        startActivity(intent);

    }
}
