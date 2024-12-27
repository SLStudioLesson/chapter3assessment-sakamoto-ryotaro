package com.recipeapp.datahandler;

import java.util.ArrayList;
//import com.recipeapp.ui.RecipeUI;
import com.recipeapp.model.Recipe;
import java.io.IOException;

public class JSONDataHandler implements DataHandler{
    @Override
    public String getMode(){
        return "JSON";
    }

    @Override
    public ArrayList<Recipe> readData()throws IOException{
        return null;
    }

    @Override
    public void writeData(Recipe recipe){
        
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword)throws IOException{
        return null;
    }

    
}
