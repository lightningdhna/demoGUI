package dhung.view;

import dhung.dbc.AccountTable;
import dhung.dbc.DatabaseConnection;
import dhung.model.Account;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainView extends Application {

    public static void  main(String... args) {

        DatabaseConnection.startConnecting();
        AccountTable.search(new Account("lasdjkf","sadfj"));
        String s= String.format("alksdfj%1$s,%1$s","asldfj");
        System.out.println(s);
        System.out.println("success");
//        launch();
        DatabaseConnection.closeConnection();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("uwu");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

    }
}
