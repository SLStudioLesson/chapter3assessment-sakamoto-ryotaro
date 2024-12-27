package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;


public class CSVDataHandler implements DataHandler{
    //レシピデータを格納するCSVファイルのパス。
    private String filePath;
    

    public CSVDataHandler(){
        this.filePath = "app/src/main/resources/recipes.csv";
    }



    @Override
    public String getMode(){
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData()throws IOException{
        ArrayList<Recipe> recipes = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line =reader.readLine()) != null){
                    String[] parts = line.split(",");
                    String name = parts[0];
                ArrayList<Ingredient>ingredients = new ArrayList<>();
                for(int i = 1;i <parts.length;i++){
                    ingredients.add(new Ingredient(parts[i].trim()));
                }
                recipes.add(new Recipe(name,ingredients));
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
            throw e;
        }
        return recipes;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            ArrayList<String> ingredientsNames = new ArrayList<>();
            for(Ingredient ingredient : recipe.getIngredients()){
                ingredientsNames.add(ingredient.getName());
            }
            String ingredients = String.join(",",ingredientsNames);
            String line= recipe.getName() + "," + ingredients;
            writer.write(line);
            writer.newLine();
        }catch(IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
            throw e;
        }
    }

    @Override 
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }



}
