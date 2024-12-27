package com.recipeapp.model;
import java.util.ArrayList;
//import java.util.List;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients ;

    public Recipe(String name,ArrayList<Ingredient> ingredients){
        this.name = name;
        this.ingredients = ingredients;
    }

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        // 空のリストを初期化
        }

    public String getName(){
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

}
