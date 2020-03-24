package org.byui.meg21allred.thymesavor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Recipe recipe);

    @Query("DELETE FROM recipe_table")
    void deleteAll();

    @Query("SELECT * from recipe_table ORDER BY title ASC")
    LiveData<List<Recipe>> getAlphabetizedTitles();

    @Update
    public void updateRecipe(Recipe recipe);

    @Delete
    public void deleteRecipe(Recipe recipe);
}
