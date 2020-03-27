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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AddRecipeRoom extends AppCompatActivity {


    private RecipeViewModel recipeViewModel;
    public static final int NEW_RECIPE_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                recipeViewModel.delete(adapter.getRecipeAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

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
           /* String title = data.getStringExtra(NewRecipeActivity.EXTRA_TITLE);
            String ingredient = data.getStringExtra(NewRecipeActivity.EXTRA_INGREDIENT);

            Recipe recipe = new Recipe(title);
            recipeViewModel.insert(recipe);*/
            Recipe recipe = new Recipe(data.getStringExtra(NewRecipeActivity.EXTRA_TITLE));
            recipeViewModel.insert(recipe);
        } else {
            System.out.println("empty, not saved");
        }
    }


}
