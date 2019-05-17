// Author: Trayvon, Vert, Jae  Date: 04/23/2019    Class: CIS-171-101

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("land.fxml"));

        primaryStage.setTitle("Subway Ordering Menu");
        primaryStage.setScene(new Scene(root, 700, 800));
        primaryStage.show();
        
        Controller.tutorial();
    }

    public static void main(String[] args) {
        launch(args);
    }
}