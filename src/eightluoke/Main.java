package eightluoke;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Utils.getInstance().config();
        Parent root = FXMLLoader.load(getClass().getResource("eightluoke.fxml"));
        primaryStage.setTitle("8洛克收费系统");
        primaryStage.setScene(new Scene(root, 1250, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
