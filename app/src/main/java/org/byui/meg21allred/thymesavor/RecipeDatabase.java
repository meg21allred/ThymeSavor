package org.byui.meg21allred.thymesavor;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Recipe.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class RecipeDatabase extends RoomDatabase {

    public abstract RecipeDao recipeDao();

    private static volatile RecipeDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RecipeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RecipeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RecipeDatabase.class, "recipe_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(RecipeDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RecipeDatabase.Callback RecipeDatabaseCallback = new RecipeDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            ArrayList<String> ingredient = new ArrayList<>();
            ArrayList<String> amount = new ArrayList<>();
            ArrayList<String> type = new ArrayList<>();
            ArrayList<String> step = new ArrayList<>();

            ingredient.add("Mac and Cheese");
            ingredient.add("Water");
            ingredient.add("Salt and Pepper");
            ingredient.add("Milk");
            amount.add("1");
            amount.add("8");
            amount.add("1/2");
            amount.add("1/4");
            type.add("Box");
            type.add("cups");
            type.add("type");
            type.add("cup");
            step.add("Bring Water to a boil");
            step.add("Open box and dump pasta contents into boiling water. Reserve cheese packet.");
            step.add("Boil for 8 minutes until pasta is tender");
            step.add("Add contents of cheese packet and stir in milk until cheese desloves");
            step.add("Enjoy!");

            //String ingredient = "Mac and Cheese";
            // If you want to keep data through app restarts,
            // comment out the following block
           /* databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                RecipeDao dao = INSTANCE.recipeDao();
               // dao.deleteAll();

                Recipe recipe = new Recipe("Mac and Cheese", ingredient, amount, type, step, "0");
                dao.insert(recipe);

            });*/
        }
    };


}
