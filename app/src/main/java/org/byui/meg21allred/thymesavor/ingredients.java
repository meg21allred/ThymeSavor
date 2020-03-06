package org.byui.meg21allred.thymesavor;

public class ingredients {
    public String ingredient;
    public int amount;
    public String amountType;

    public ingredients(String ingredient, int amount, String amountType) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.amountType = amountType;
    }

    public String getIngredient() {
        return ingredient;
    }

    public int getAmount() {
        return amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAmountType(String setAmountType) {
        this.amountType = amountType;
    }

}
