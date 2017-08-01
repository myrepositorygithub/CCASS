package Control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by thiago on 7/4/17.
 */
public class ImprimeCheque2 {


    @FXML
    private String nome;
    @FXML
    private String cpf;
    @FXML
    private TextField valor;
    @FXML
    private TextField quantidade;
    @FXML
    private Button imprime;
    @FXML
    private Button cancela;

    private int distCima = CCASS.config.distanciaIntermediaria;
    private int distEsquerda = CCASS.config.deslocamentoEsquerda1;
    private int distEsquerda2 = CCASS.config.deslocamentoEsquerda2;
    private int inicial = CCASS.config.distanciaInicial;



    public int getDistCima() {
        return distCima;
    }

    public void setDistCima(int distCima) {
        this.distCima = distCima;
    }

    public int getDistEsquerda() {
        return distEsquerda;
    }

    public void setDistEsquerda(int distEsquerda) {
        this.distEsquerda = distEsquerda;
    }

    // onAction="#"

    @FXML
    public void initialize(){
        this.nome = CCASS.atual.getNome();
        this.cpf = CCASS.atual.getCPF();
    }


    @FXML
    public void sobe() {
        if (distCima > 0)
            distCima -= 1;
    }

    @FXML
    public void desce() {
        distCima += 1;
    }

    @FXML
    public void recua() {
        if (distEsquerda > 0)
            distEsquerda -= 1;
    }

    @FXML
    public void avanca() {
        distEsquerda += 1;
    }

    @FXML
    public void imprime() {
        String saida = "";
        if (nome.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o Nome!\n");
            alert.showAndWait();
            System.out.println("Campo Obrigatório: Nome");
            return;
        } else if (valor.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o Valor por página!\n");
            alert.showAndWait();
            System.out.println("Campo Obrigatório: Valor");
            return;
        } else if (cpf.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o CPF!\n");
            alert.showAndWait();
            System.out.println("Campo Obrigatório: CPF");
            return;
        }



        for (int i = distCima; i > 0; i--) {
            saida += "\n";
        }

        for (int i = distEsquerda; i > 0; i--) {
            saida += "\t";
        }
        saida += "R$ " + valor.getText() + ",00\n";
        for (int i = distEsquerda + distEsquerda2; i > 0; i--) {
            saida += "\t";
        }
        saida += nome + "\n";
        for (int i = distEsquerda + distEsquerda2 +1; i > 0; i--) {
            saida += "\t";
        }
        saida += cpf + "\n\n";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Imprimindo");
        alert.setHeaderText(null);
        alert.setContentText("Distancia Esquerda:" + distEsquerda + "\n" + "Distancia Acima:" + distCima + "\n");
        alert.showAndWait();
        System.out.println("Distancia Esquerda:" + distEsquerda + "\n" + "Distancia Acima:" + distCima + "\n");

        String aux = "";

        for (int i = 0; i < Integer.parseInt(quantidade.getText()); i++) {
            aux += saida;
        }
        saida = "";
        for (int i = inicial; i > 0; i--) {
            saida += "\n";
        }
        saida = saida+aux;
        //ControladoraPrincipal.enviaImpressao(saida);
        System.out.println(saida);
        closeButtonAction();


    }

    @FXML
    public void cancela() {
        closeButtonAction();
    }

    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) cancela.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
