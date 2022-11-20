package dhung.view;

import dhung.dbc.AccountTable;
import dhung.dbc.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {

    public static void  main(String... args) {
        DatabaseConnection.getConnection();
        launch();
        DatabaseConnection.closeConnection();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("uwu");
        stage.setScene(scene);
        stage.show();
    }
}
