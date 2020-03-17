package org.byui.meg21allred.thymesavor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AddIngredientsDao {

    @Insert
    void insert(AddIngredients addIngredients);

    @Update
    void update(AddIngredients addIngredients);

    @Delete
    void delete(AddIngredients addIngredients);

    @Query("DELETE FROM addIngredents_table")
    void deleteAllIngredients();

    @Query("SELECT * FROM addIngredents_table ORDER BY priority DESC")
    LiveData<List<AddIngredients>> getAllIngredients();
}
