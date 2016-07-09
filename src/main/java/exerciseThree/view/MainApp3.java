package exerciseThree.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp3 extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent rootLayout = FXMLLoader.load(getClass().getResource("/exercise3/exercise3.fxml"));
        primaryStage.setTitle("Exercise 3 - Charts App");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }



    public void start3() throws IOException {
        Parent rootLayout = FXMLLoader.load(getClass().getResource("/exercise3/exercise3.fxml"));
        Stage someStage;
        someStage = new Stage();
        someStage.setTitle("Exercise 3 - Charts App");
        someStage.setScene(new Scene(rootLayout));
        someStage.showAndWait();
    }
}