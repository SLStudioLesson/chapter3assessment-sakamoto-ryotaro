import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;


public class App {

    public static void main(String[] args) {

        /*
         * [1]・[2]または、それ以外の入力時の処理の分岐を行う。
        */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            int choice1 = Integer.parseInt(choice);
            DataHandler dataHandler = null;
            System.out.println();
            if(choice1 == 1 || choice1 != 2){
                dataHandler =new CSVDataHandler();
            }else if(choice1 == 2){
                dataHandler = new JSONDataHandler();
            }
            RecipeUI ui = new RecipeUI(dataHandler);
            ui.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}