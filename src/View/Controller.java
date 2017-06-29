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

        System.out.println("testa impressao");
    }

    public void printCheck(ActionEvent actionEvent) {

        System.out.println("testa impressao");
        try {
            FileOutputStream os = new FileOutputStream("LPT1");
            //wrap stream in "friendly" PrintStream
            PrintStream ps = new PrintStream(os);

            //print text here
            ps.println("Can anybody find me somebody to love?\n" +
                    "Each morning I get up I die a little\n" +
                    "Can barely stand on my feet\n" +
                    "(Take a look at yourself) Take a look in the mirror and cry\n" +
                    "Lord what you're doing to me\n" +
                    "I have spent all my years in believing you\n" +
                    "But I just can't get no relief Lord\n" +
                    "Somebody (somebody) ooh somebody (somebody)\n" +
                    "Can anybody find me somebody to love?\n" +
                    "\n" +
                    "I work hard (he works hard) everyday of my life\n" +
                    "I work till I ache my bones\n" +
                    "At the end (at the end of the day)\n" +
                    "I take home my hard earned pay all on my own\n" +
                    "I get down (down) on my knees (knees)\n" +
                    "And I start to pray (praise the Lord)\n" +
                    "Till the tears run down from my eyes\n" +
                    "Lord somebody (somebody) ooh somebody (please)\n" +
                    "Can anybody find me somebody to love?\n" +
                    "(He wants help)\n" +
                    "\n" +
                    "Every day - I try and I try and I try\n" +
                    "But everybody wants to put me down\n" +
                    "They say I'm goin' crazy\n" +
                    "They say I got a lot of water in my brain\n" +
                    "Got no common sense\n" +
                    "I got nobody left to believe\n" +
                    "Yeah - yeah yeah yeah\n" +
                    "Ooh\n" +
                    "\n");

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
