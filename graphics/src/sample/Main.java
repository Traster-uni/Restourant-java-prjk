package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        String restaurantHistory = "C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\restaurantHistory.txt";
        try {
            File inpurFile = new File(restaurantHistory);
            if (!inpurFile.exists()){
                inpurFile.createNewFile();
            }
        }
        catch ( IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Restaurant");
        primaryStage.setScene(new Scene(root, 782, 584));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


//    public static void main(String[] args) {
//        launch(args);
//        String restaurantHistory = "C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\restaurantHistory.txt";
//        try {
//            File inpurFile = new File(restaurantHistory);
//            if (!inpurFile.exists()){
//                inpurFile.createNewFile();
//            }
//        }
//        catch ( IOException e){
//            System.out.println(e);
//        }
//    }
}
