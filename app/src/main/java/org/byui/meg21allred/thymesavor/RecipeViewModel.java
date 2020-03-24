package org.byui.meg21allred.thymesavor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

    private RecipeRepository repository;
    private LiveData<List<Recipe>> allrecipes;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        repository = new RecipeRepository(application);
        allrecipes = repository.getAllRecipes();
    }

    LiveData<List<Recipe>> getAllrecipes() {return allrecipes;}
    public void insert(Recipe recipe) {repository.insert(recipe);}
}
