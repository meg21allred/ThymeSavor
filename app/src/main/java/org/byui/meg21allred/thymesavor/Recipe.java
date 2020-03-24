package org.byui.meg21allred.thymesavor;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "recipe_table")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "title")
    private String title;
    /*@NonNull
    @ColumnInfo(name = "ingredient")
    private String ingredient;
    private double amount;
    @NonNull
    @ColumnInfo(name = "type")
    private String type;
    @NonNull
    @ColumnInfo(name = "step")
    private String step;

    public Recipe(String title, String ingredient, double amount, String type, String step) {
        this.title = title;
        this.ingredient = ingredient;
        this.amount = amount;
        this.type = type;
        this.step = step;
    }*/

    public Recipe(@NonNull String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

   /* public String getIngredient() {
        return ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getStep() {
        return step;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
