package org.byui.meg21allred.thymesavor;

import java.util.List;

public class Recipe {
    private String recipeTitle;
    private List <ingredients> ingredients;
    private List <steps> steps;
    private List <String> tags;

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public List<ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List <ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<steps> getSteps() {
        return steps;
    }

    public void setSteps(List<steps> steps) {
        this.steps = steps;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTitle() {

    }

    public void addIngredients() {

    }

    public void addIngredientAmount() {

    }

    public void addIngredientType() {

    }

    public void addSteps() {

    }
}
