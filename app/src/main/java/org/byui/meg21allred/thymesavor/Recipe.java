package org.byui.meg21allred.thymesavor;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "recipe_table")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "title")
    private String title;
    private ArrayList<String> ingredient = new ArrayList<>();
    //private String ingredient;
    //private String amount;
    private ArrayList<String> amount = new ArrayList<>();

    //private String type;
    private ArrayList<String> type = new ArrayList<>();
    //private String step;
    private ArrayList<String> step = new ArrayList<>();

    public Recipe() {}


    public Recipe(String title, ArrayList<String> ingredient, ArrayList<String> amount,
                  ArrayList<String> type, ArrayList<String> step) {
        this.title = title;
        this.ingredient = ingredient;
        this.amount = amount;
        this.type = type;
        this.step = step;

    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getIngredient() {
        return ingredient;
    }

    public ArrayList<String> getAmount() {
        return amount;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public ArrayList<String> getStep() {
        return step;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIngredient(ArrayList<String> ingredient) {
        this.ingredient = ingredient;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setAmount(ArrayList<String> amount) {
        this.amount = amount;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public void setStep(ArrayList<String> step) {
        this.step = step;
    }
}
