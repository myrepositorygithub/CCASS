package Control;

import Model.Associado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;

import static Control.CCASS.dados;

public class ControladoraPrincipal {

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
    @FXML
    private ListView<Associado> listaAssociados;

    @FXML
    private TableView<Associado> tabela = new TableView<>();
    @FXML
    private TableColumn<Associado, String> colunaNome;
    @FXML
    private TableColumn<Associado, String> colunaTel;
    @FXML
    private TableColumn<Associado, String> colunaCPF;
    @FXML
    private TableColumn colunaTeste = new TableColumn("Action");
    @FXML
    public static ObservableList<Associado> associados = FXCollections.observableArrayList();


    public ControladoraPrincipal() {
        // Inserir alguns dados para teste
        /*
        CCASS.dados.associados.add(new Associado("Thiago Oliveira Cabral", "131.378.671-59", "2029519-6", "65 99887755", "Rua Das Batatas"));
        CCASS.dados.associados.add(new Associado("Glaupe Cristina De Oliveira Cabral", "231.378.671-59", "2029519-6", "65 99887755", "Rua Das Batatas"));
        CCASS.dados.associados.add(new Associado("Lívia Cristina de  Oliveira Cabral", "331.378.671-59", "2029519-6", "65 99887755", "Rua Das Batatas"));
        */
        for (Associado aux :
                CCASS.dados.associados) {
            associados.add(aux);
        }
    }

    @FXML
    private void initialize() {
        // Inicializar as colunas
        colunaNome.setCellValueFactory(new PropertyValueFactory<Associado, String>("Nome"));
        colunaTel.setCellValueFactory(new PropertyValueFactory<Associado, String>("Tel"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<Associado, String>("CPF"));
        colunaTeste.setCellValueFactory(new PropertyValueFactory<>("Dummy"));
        System.out.println(associados.size());

        Callback<TableColumn<Associado, String>, TableCell<Associado, String>> cellFactory
                = //
                new Callback<TableColumn<Associado, String>, TableCell<Associado, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Associado, String> param) {
                        final TableCell<Associado, String> cell = new TableCell<Associado, String>() {

                            final Button btn = new Button("Imprimir");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        Associado person = getTableView().getItems().get(getIndex());
                                        System.out.println(person.getNome()
                                                + "   " + person.getCPF());

                                        printCheck(person);
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        colunaTeste.setCellFactory(cellFactory);
        colunaTeste.setSortable(false);
        tabela.setItems(associados);

        tabela.setEditable(false);

    }


    public void encerraSecao(ActionEvent actionEvent) {

        System.out.println("testa encerrar");

        Dados.descarrega(CCASS.dados.associados);

        try {
            dados.encerraPrograma();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }


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

    public void printCheck(Associado associado){
        CCASS.atual = associado;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/imprimirCheque2.fxml"));
            Parent mainWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Imprimir Cheque");
            stage.setScene(new Scene(mainWindow));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printCheck(ActionEvent actionEvent) {


        System.out.println("teste");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/imprimeCheque.fxml"));
            Parent mainWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Imprimir Cheque");
            stage.setScene(new Scene(mainWindow));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void enviaImpressao(String saida) {
        System.out.println("ainda nao");
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/cadastraCliente.fxml"));
            Parent mainWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Cadastra Associado");
            stage.setScene(new Scene(mainWindow, 600, 510));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void cadastraConvenio(ActionEvent actionEvent) {

        System.out.println("teste");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/cadastraConvenio.fxml"));
            Parent mainWindow = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Cadastra Concênio");
            stage.setScene(new Scene(mainWindow, 600, 330));
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
