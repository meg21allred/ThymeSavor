package org.byui.meg21allred.thymesavor;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;
//this class is need to make the room library function
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

    void update(Recipe recipe) {
        RecipeDatabase.databaseWriteExecutor.execute(() -> {
            recipeDao.update(recipe);
        });
    }

    void delete(Recipe recipe) {
        RecipeDatabase.databaseWriteExecutor.execute(() -> {
            recipeDao.delete(recipe);
        });
    }


}
