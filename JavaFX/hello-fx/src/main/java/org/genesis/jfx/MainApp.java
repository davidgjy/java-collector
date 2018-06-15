package org.genesis.jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MainApp
 * @Package org.genesis.jfx
 * @Description: jfx main
 * @date 2018/6/15 16:40
 */
public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());

        primaryStage.setTitle("Simple JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
