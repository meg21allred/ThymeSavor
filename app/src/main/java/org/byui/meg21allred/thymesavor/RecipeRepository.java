package org.byui.meg21allred.thymesavor;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecipeRepository {
    private RecipeDao recipeDao;
    private LiveData<List<Recipe>> allRecipes;

    RecipeRepository(Application application) {
        RecipeDatabase db = RecipeDatabase.getDatabase(application);
        recipeDao = db.recipeDao();
        allRecipes = recipeDao.getAlphabetizedTitles();
    }

    LiveData<List<Recipe>> getAllRecipes() {
        return allRecipes;
    }

    void insert(Recipe recipe) {
        RecipeDatabase.databaseWriteExecutor.execute(() -> {
            recipeDao.insert(recipe);
        });
    }
}
