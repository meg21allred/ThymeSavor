package org.byui.meg21allred.thymesavor;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

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

    public void update(Recipe recipe) {
        new UpdateRecipeAsyncTask(recipeDao).execute(recipe);
    }

    public void delete(Recipe recipe) {
        new DeleteRecipeAsyncTask(recipeDao).execute(recipe);
    }

    /*public LiveData<List<Recipe>>  getAllRecipes() {
        return allRecipes;
    }*/

    private static class UpdateRecipeAsyncTask extends AsyncTask<Recipe, Void, Void> {
        private RecipeDao RecipeDao;

        private UpdateRecipeAsyncTask(RecipeDao recipeDao) {
            this.RecipeDao = RecipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            RecipeDao.update(recipes[0]);
            return null;
        }
    }

    private static class DeleteRecipeAsyncTask extends AsyncTask<Recipe, Void, Void> {
        private RecipeDao recipeDao;

        private DeleteRecipeAsyncTask(RecipeDao recipeDao) {
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.delete(recipes[0]);
            return null;
        }
    }
}
