package Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CCASS extends Application {

    public static Dados dados;

    @Override
    public void start(Stage primaryStage) throws Exception{

        dados = new Dados();
        Parent root = FXMLLoader.load(getClass().getResource("/View/mainWindow.fxml"));
        primaryStage.setTitle("Controle de Clientes Asserjup");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
