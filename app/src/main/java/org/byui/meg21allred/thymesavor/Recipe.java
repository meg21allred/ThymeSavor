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
    private String amount;
    @NonNull
    @ColumnInfo(name = "type")
    private String type;

    @NonNull
    @ColumnInfo(name = "step")
    private String step;

    public Recipe() {}


    public Recipe(String title, ArrayList<String> ingredient, String amount, String type, String step) {
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

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getStep() {
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

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    public void setStep(@NonNull String step) {
        this.step = step;
    }
}
