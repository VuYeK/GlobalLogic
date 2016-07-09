package exerciseOne.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent rootLayout = FXMLLoader.load(getClass().getResource("/exercise1/exercise1.fxml"));
        primaryStage.setTitle("Exercise 1");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

    public void start1() throws IOException {
        Parent rootLayout = FXMLLoader.load(getClass().getResource("/exercise1/exercise1.fxml"));
        Stage someStage;
        someStage = new Stage();
        someStage.setTitle("Exercise 1");
        someStage.setScene(new Scene(rootLayout));
        someStage.showAndWait();
    }
}
