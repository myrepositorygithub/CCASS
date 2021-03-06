package Control;

import Model.Associado;
import Model.Configuracoes;
import Model.Dados;
import Model.XMLParser;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class CCASS extends Application {

    public static Dados dados;
    public static Associado atual;
    public static Configuracoes config;
    public static XMLParser parser;

    @Override
    public void start(Stage primaryStage) throws Exception{

        parser = new XMLParser();
        dados = new Dados();
        XMLParser teste = new XMLParser();
        Parent root = FXMLLoader.load(getClass().getResource("/View/janelaPrincipal.fxml"));
        primaryStage.setTitle("Controle de Clientes Asserjup");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Fechando Programa");
                try {
                    dados.encerraPrograma();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
