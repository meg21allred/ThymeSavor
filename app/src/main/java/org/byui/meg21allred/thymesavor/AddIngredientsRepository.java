package org.byui.meg21allred.thymesavor;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AddIngredientsRepository {
    private AddIngredientsDao addIngredientsDao;
    private LiveData<List<AddIngredients>> allIngredients;

    public AddIngredientsRepository(Application application) {
        AddIngredientsDatabase database = AddIngredientsDatabase.getInstance(application);
        addIngredientsDao = database.addIngredientsDao();
        allIngredients = addIngredientsDao.getAllIngredients();
    }

    public void insert(AddIngredients addIngredients) {

    }

    public void update(AddIngredients addIngredients) {

    }

    public void delete(AddIngredients addIngredients) {

    }

    public void deleteAllIngredients() {

    }

    public LiveData<List<AddIngredients>> getAllIngredients() {
        return allIngredients;
    }

}
