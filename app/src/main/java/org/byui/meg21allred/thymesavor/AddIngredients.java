package org.byui.meg21allred.thymesavor;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addIngredents_table")
public class AddIngredients {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String amount;
    private String ingredient;
    private int priority;

    public AddIngredients(String title, String amount, String ingredient, int priority) {
        this.title = title;
        this.amount = amount;
        this.ingredient = ingredient;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public String getIngredient() {
        return ingredient;
    }

    public int getPriority() {
        return priority;
    }


}
