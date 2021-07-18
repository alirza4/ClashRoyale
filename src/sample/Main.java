package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;



    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        setStage(stage);
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("Loggin.fxml"));
        primaryStage.setTitle("clashRoyal");
        primaryStage.setScene(new Scene(root, 588, 388));
        primaryStage.show();
//        LoadingController Lc=new LoadingController();
//        Lc.Load();
    }
    public void changeScene(String fxml)throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }
    public static Stage getStage() {
        return stage;
    }
    public void unvisible(){
        stage.hide();
    }
    public void visible(){
        stage.show();
    }
    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}