package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.ArrayList;
// import java.util.List;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;



public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                    displayRecipes();
                        break;
                    case "2":
                    addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
            
        }
    }
    
    private void displayRecipes(){
            try{
                ArrayList<Recipe> recipes = dataHandler.readData();
                    if(recipes == null || recipes.isEmpty()){
                        System.out.println("No recipes available.");
                        return;
                    }
                    System.out.println("Recipes:");
                    for(Recipe recipe : recipes){
                        System.out.println("-----------------------------------");
                    System.out.println("Recipe Name: " + recipe.getName());
                    ArrayList<String> ingredientNames = new ArrayList<>();
                    for (Ingredient ingredient : recipe.getIngredients()) {
                        ingredientNames.add(ingredient.getName());
                    }
                    String ingredients = String.join(",",ingredientNames);
                    System.out.println("Main Ingredients: " + ingredients);
                    }
                    System.out.println("-----------------------------------");
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
    
            private void addNewRecipe(){
                try{
                System.out.println("Adding a new recipe.");
                System.out.print("Enter recipe name: ");
                String name = reader.readLine();
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                System.out.println("Enter ingredients (type 'done' when finished):");
                while(true){
                    System.out.print("Ingredient: ");
                    String ingredientName = reader.readLine();
                    if(ingredientName.equals("done")){
                        break;
                    }
                    ingredients.add(new Ingredient(ingredientName));
                }
                    Recipe recipe = new Recipe(name, ingredients);
                    dataHandler.writeData(recipe);
                    System.out.println("Recipe added successfully.");
                }catch(IOException e){
                    System.out.println("Failed to add new recipe: " + e.getMessage()); }
            } 

                
    }
            
            


            



