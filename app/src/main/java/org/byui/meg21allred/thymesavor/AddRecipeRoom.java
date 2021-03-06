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
//This class is the driver for the room library

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

        //RecyclerView displays the clickable titles of the recipes
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
        //TouchHelper is used to permit a swiping function that is used in the app to delete the recipes
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

        //This is how all the infomation for each recipe it saved
        adapter.setOnItemClickListener(new RecipeListAdapter.ClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(AddRecipeRoom.this, NewRecipeActivity.class);
                intent.putExtra(NewRecipeActivity.EXTRA_ID, recipe.getId());
                intent.putExtra(NewRecipeActivity.EXTRA_TITLE, recipe.getTitle());
                intent.putStringArrayListExtra(NewRecipeActivity.EXTRA_INGREDIENT, recipe.getIngredient());
                intent.putStringArrayListExtra(NewRecipeActivity.EXTRA_AMOUNT, recipe.getAmount());
                intent.putStringArrayListExtra(NewRecipeActivity.EXTRA_TYPE, recipe.getType());
                intent.putStringArrayListExtra(NewRecipeActivity.EXTRA_STEP, recipe.getStep());
                intent.putExtra(NewRecipeActivity.EXTRA_RATING, recipe.getRating());

                startActivityForResult(intent, EDIT_RECIPE_ACTIVITY_REQUEST_CODE);

            }
        });
        //floating button is used to add a new recipe
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipeRoom.this, NewRecipeActivity.class);
                startActivityForResult(intent, NEW_RECIPE_ACTIVITY_REQUEST_CODE);
            }
        });
    }
    //This function will save and update the recipe if RESULT_OK
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_RECIPE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String title = data.getStringExtra(NewRecipeActivity.EXTRA_TITLE);
            ArrayList<String> ingredient = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_INGREDIENT);
            ArrayList<String> amount = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_AMOUNT);
            ArrayList<String> type = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_TYPE);
            ArrayList<String> step = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_STEP);
            String rating = data.getStringExtra(NewRecipeActivity.EXTRA_RATING);

            Recipe recipe = new Recipe(title, ingredient, amount, type, step, rating);
            recipeViewModel.insert(recipe);
        } else if (requestCode == EDIT_RECIPE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            int id = data.getIntExtra(NewRecipeActivity.EXTRA_ID, -1);

            if (id == -1) {
                System.out.println("Recipe can't be updated");
                return;
            }

            String title = data.getStringExtra(NewRecipeActivity.EXTRA_TITLE);
            ArrayList<String> ingredient = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_INGREDIENT);
            ArrayList<String> amount = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_AMOUNT);
            ArrayList<String> type = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_TYPE);
            ArrayList<String> step = data.getStringArrayListExtra(NewRecipeActivity.EXTRA_STEP);
            String rating = data.getStringExtra(NewRecipeActivity.EXTRA_RATING);

            Recipe recipe = new Recipe(title, ingredient, amount, type, step, rating);
            recipe.setId(id);
            recipeViewModel.update(recipe);

        } else {
            System.out.println("empty, not saved");
        }
    }


}
