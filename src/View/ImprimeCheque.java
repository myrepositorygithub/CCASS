package View;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by thiago on 7/4/17.
 */
public class ImprimeCheque {


    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private TextField valor;
    @FXML
    private Button cima;
    @FXML
    private Button baixo;
    @FXML
    private Button esquerda;
    @FXML
    private Button direita;
    @FXML
    private Button imprime;
    @FXML
    private Button cancela;

    private int distCima = 10;
    private int distEsquerda = 5;


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
    public void sobe() {
        distCima += 1;
    }

    @FXML
    public void desce() {
        distCima -= 1;
    }

    @FXML
    public void recua() {
        distEsquerda -= 1;
    }

    @FXML
    public void avanca() {
        distEsquerda += 1;
    }

    @FXML
    public void imprime() {
        String saida = "";
        if (nome.getText().isEmpty()) {
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
        } else if (cpf.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o CPF!\n");
            alert.showAndWait();
            System.out.println("Campo Obrigatório: CPF");
            return;
        }
        String l1, separacao;
        for (int i = distCima; i > 0; i--) {
            saida += ".\n";
        }
        for (int i = distEsquerda; i > 0; i--) {
            saida += ".\t";
        }
        saida += "R$ " + valor.getText() + ",00";
        saida += "\t\t\t\t";
        saida += nome.getText() + "\n";
        for (int i = distEsquerda; i > 0; i--) {
            saida += ".\t";
        }
        saida += "\t\t\t\t\t\t" + cpf.getText() + "\n";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Imprimindo");
        alert.setHeaderText(null);
        alert.setContentText("Distancia Esquerda:" + distEsquerda + "\n"+"Distancia Acima:" + distCima + "\n");
        alert.showAndWait();
        System.out.println("Distancia Esquerda:" + distEsquerda + "\n"+"Distancia Acima:" + distCima + "\n");


        System.out.println(saida);
        Controller.enviaImpressao(saida);
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
