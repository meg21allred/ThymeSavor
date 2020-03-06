package org.byui.meg21allred.thymesavor;

import java.util.List;

public class steps {

    public String directions;
    public List<ingredients> ingredientsList;


    public steps(String directions, List<ingredients> ingredientsList) {
        this.directions = directions;
        this.ingredientsList = ingredientsList;
    }

    public String getDirections() {
        return directions;
    }

    public List getList() {
        return ingredientsList;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

}
