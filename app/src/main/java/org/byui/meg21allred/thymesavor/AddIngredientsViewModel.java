package org.byui.meg21allred.thymesavor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddIngredientsViewModel extends AndroidViewModel {

    private AddIngredientsRepository repository;
    private LiveData<List<AddIngredients>> allIngredients;

    public AddIngredientsViewModel(@NonNull Application application) {
        super(application);
        repository = new AddIngredientsRepository(application);
        allIngredients = repository.getAllIngredients();
    }

    public void insert(AddIngredients addIngredients) {
        repository.insert(addIngredients);
    }

    public void update(AddIngredients addIngredients) {
        repository.update(addIngredients);
    }

    public void delete(AddIngredients addIngredients) {
        repository.delete(addIngredients);
    }

    public void deleteAllIngredients() {
        repository.deleteAllIngredients();
    }

    public LiveData<List<AddIngredients>> getAllIngredients() {
        return allIngredients;
    }
}
