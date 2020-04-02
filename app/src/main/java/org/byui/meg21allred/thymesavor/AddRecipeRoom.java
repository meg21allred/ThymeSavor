package org.byui.meg21allred.thymesavor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AddRecipeRoom extends AppCompatActivity {


    private RecipeViewModel recipeViewModel;
    public static final int NEW_RECIPE_ACTIVITY_REQUEST_CODE = 1;
    public static final int EDIT_RECIPE_ACTIVITY_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_recipe_room);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final RecipeListAdapter adapter = new RecipeListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);

        recipeViewModel.getAllrecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable final List<Recipe> recipes) {
                //Update the chached copy of the words in the adapter.
                adapter.setRecipes(recipes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                recipeViewModel.delete(adapter.getRecipeAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new RecipeListAdapter.ClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(AddRecipeRoom.this, NewRecipeActivity.class);
                intent.putExtra(NewRecipeActivity.EXTRA_ID, recipe.getId());
                intent.putExtra(NewRecipeActivity.EXTRA_TITLE, recipe.getTitle());
                intent.putStringArrayListExtra(NewRecipeActivity.EXTRA_INGREDIENT, recipe.getIngredient());
                intent.putExtra(NewRecipeActivity.EXTRA_AMOUNT, recipe.getAmount());
                intent.putExtra(NewRecipeActivity.EXTRA_TYPE, recipe.getType());
                intent.putExtra(NewRecipeActivity.EXTRA_STEP, recipe.getStep());
                //Intent.putExtra(NewRecipeActivity.EXTRA_RATING, recipe.getRating());

                startActivityForResult(intent, EDIT_RECIPE_ACTIVITY_REQUEST_CODE);

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipeRoom.this, NewRecipeActivity.class);
                startActivityForResult(intent, NEW_RECIPE_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_RECIPE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String title = data.getStringExtra(NewRecipeActivity.EXTRA_TITLE);
            ArrayList<String> ingredient = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_INGREDIENT);
            //String ingredient = data.getStringExtra(NewRecipeActivity.EXTRA_INGREDIENT);
            String amount = data.getStringExtra(NewRecipeActivity.EXTRA_AMOUNT);
            String type = data.getStringExtra(NewRecipeActivity.EXTRA_TYPE);
            String step = data.getStringExtra(NewRecipeActivity.EXTRA_STEP);

            Recipe recipe = new Recipe(title, ingredient, amount, type, step);
            recipeViewModel.insert(recipe);
        } else if (requestCode == EDIT_RECIPE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            int id = data.getIntExtra(NewRecipeActivity.EXTRA_ID, -1);

            if (id == -1) {
                System.out.println("Recipe can't be updated");
                return;
            }

            String title = data.getStringExtra(NewRecipeActivity.EXTRA_TITLE);
            ArrayList<String> ingredient = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_INGREDIENT);
            //String ingredient = data.getStringExtra(NewRecipeActivity.EXTRA_INGREDIENT);
            String amount = data.getStringExtra(NewRecipeActivity.EXTRA_AMOUNT);
            String type = data.getStringExtra(NewRecipeActivity.EXTRA_TYPE);
            String step = data.getStringExtra(NewRecipeActivity.EXTRA_STEP);

            Recipe recipe = new Recipe(title, ingredient, amount, type, step);
            recipe.setId(id);
            recipeViewModel.update(recipe);

        } else {
            System.out.println("empty, not saved");
        }
    }


}
