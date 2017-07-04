package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class Controller {

    /**
     * * Variaveis de interface **
     */

    @FXML
    private MenuItem atualizarDados;
    @FXML
    private MenuItem backup;
    @FXML
    private MenuItem imprimirRelatorio;
    @FXML
    private MenuItem sair;
    @FXML
    private MenuItem cadastrarAssociado;
    @FXML
    private MenuItem buscarAssociado;
    @FXML
    private MenuItem listarAssociados;
    @FXML
    private MenuItem cadastrarConvenio;
    @FXML
    private MenuItem buscarConvenio;
    @FXML
    private MenuItem listarConvenio;
    @FXML
    private MenuItem update;
    @FXML
    private MenuItem bugReport;
    @FXML
    private MenuItem about;


    public void encerraSecao(ActionEvent actionEvent) {

        System.out.println("testa encerrar");
        System.exit(0);


    }

    public void refresh(ActionEvent actionEvent) {

        System.out.println("testa atualizar");
    }

    public void backup(ActionEvent actionEvent) {

        System.out.println("testa backup");
    }

    public void printResume(ActionEvent actionEvent) {
        String saida = "";
        for (int i = 500; i > 0; i--) {
            saida += ". ";
        }
        enviaImpressao(saida);
        System.out.println("testa impressao");
    }

    public void printCheck(ActionEvent actionEvent) {


        System.out.println("teste");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("imprimeCheque.fxml"));
            Parent mainWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Cadastra Associado");
            stage.setScene(new Scene(mainWindow));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        System.out.println("testa chequinho");
        try {
            FileOutputStream os = new FileOutputStream("LPT1");
            //wrap stream in "friendly" PrintStream
            PrintStream ps = new PrintStream(os);

            //print text here
            System.out.println("somebody");
            ps.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");     // posicionar o carro da impressora na parte inferior do cheque
            ps.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNome fictício 1\n");
            ps.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t000.000.000-00 1\n");

            //form feed -- this is important
            //Without the form feed, the text will simply sit
            // in print buffer until something else gets printed.
            ps.print("\f");
            //flush buffer and close
            ps.close();
            System.out.println("to");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
            System.out.println("love");
        }


        */
    }


    public static void enviaImpressao(String saida) {
        try {
            FileOutputStream os = new FileOutputStream("LPT1");
            //wrap stream in "friendly" PrintStream
            PrintStream ps = new PrintStream(os);

            //print text here
            //System.out.println("somebody");
            ps.print(saida);
            //form feed -- this is important
            //Without the form feed, the text will simply sit
            // in print buffer until something else gets printed.
            ps.print("\f");
            //flush buffer and close
            ps.close();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
    }

    public void cadastraAssociado(ActionEvent actionEvent) {

        System.out.println("teste");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastraCliente.fxml"));
            Parent mainWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Cadastra Associado");
            stage.setScene(new Scene(mainWindow, 600, 300));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    public void encerraSecao(ActionEvent actionEvent) {

        System.out.println("teste");
    }
*/
}
