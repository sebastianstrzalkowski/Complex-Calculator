package pl.sebastianstrzalkowski.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String args[]){
        launch(args);
    }

    public void start(Stage stage) throws IOException{
        AnchorPane myPane = (AnchorPane) FXMLLoader.load(getClass().getResource
                ("controllers/fxml/Calculator.fxml"));
        Scene myScene = new Scene(myPane);

        stage.setTitle("Kalkulator lcizb zespolonych");
        stage.setScene(myScene);
        stage.show();
    }
}
