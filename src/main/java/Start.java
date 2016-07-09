import exerciseOne.view.MainApp1;
import exerciseThree.view.MainApp3;
import exerciseTwo.view.MainApp2;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by VuYeK on 08.07.2016.
 */
public class Start extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent rootLayout = FXMLLoader.load(getClass().getResource("/RootLayout.fxml"));
        primaryStage.setTitle("GlobalLogic");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

    @FXML
    protected void start_ex1() throws IOException {
        MainApp1 ex1 = new MainApp1();
        ex1.start1();
    }

    @FXML
    protected void start_ex2() throws IOException {
        MainApp2 ex2 = new MainApp2();
        ex2.start2();
    }

    @FXML
    protected void start_ex3() throws IOException {
        MainApp3 ex3 = new MainApp3();
        ex3.start3();
    }
}