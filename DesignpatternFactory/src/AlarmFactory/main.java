package AlarmFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Alarmanlagen");
        primaryStage.setScene(new Scene(root, 599, 370));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
