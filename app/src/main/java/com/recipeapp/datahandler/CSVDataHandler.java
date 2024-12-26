package com.recipeapp.datahandler;


public class CSVDataHandler implements DataHandler{
    //レシピデータを格納するCSVファイルのパス。
    public String filePath;
    public CSVDataHandler(){
        this.filePath = "/app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath){
        this.filePath = filePath;
    }

    @Override
    public String getMode(){
        String moji1 = "CSV";
        return moji1;
    }

    @Override
    public String readData(){
        return null;
    }

    @Override
    public void String writeData(){
        
    }

    @Override
    public String searchData(){
        return null;
    }
}
