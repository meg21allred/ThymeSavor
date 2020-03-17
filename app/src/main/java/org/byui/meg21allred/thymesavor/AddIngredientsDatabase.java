package org.byui.meg21allred.thymesavor;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AddIngredients.class}, version = 1, exportSchema = false)
public abstract class AddIngredientsDatabase extends RoomDatabase {

    private static AddIngredientsDatabase instance;

    public abstract AddIngredientsDao addIngredientsDao();

    public static synchronized AddIngredientsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AddIngredientsDatabase.class, "add_ingredient_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
