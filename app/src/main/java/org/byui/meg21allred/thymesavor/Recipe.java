package org.byui.meg21allred.thymesavor;

import java.util.List;

public class Recipe {
    private String recipeTitle;
    private List <Ingredient> ingredients;
    private List <Step> steps;
    private List <String> tags;

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
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

    public void addSteps() {

    }
}
