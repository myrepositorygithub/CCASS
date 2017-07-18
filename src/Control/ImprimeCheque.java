package Control;

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
    private TextField quantidade;
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
    private int distEsquerda = 4;


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
            saida += "\n";
        }

        for (int i = distEsquerda; i > 0; i--) {
            saida += "\t";
        }
        saida += "R$ " + valor.getText() + ",00\n";
        for (int i = distEsquerda + 3; i > 0; i--) {
            saida += "\t";
        }
        saida += nome.getText() + "\n";
        for (int i = distEsquerda + 3; i > 0; i--) {
            saida += "\t";
        }
        saida += cpf.getText() + "\n\n";

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
        saida = aux;
        Controller.enviaImpressao(saida);
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
