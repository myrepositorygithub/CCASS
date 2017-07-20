package Control;

import Model.Convenio;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastraConvenio {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField cnpjField;
    @FXML
    private TextField fantasiaField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField enderecoField;
    @FXML
    private TextField foneField;

    @FXML
    public void novoConvenio() {

        if (nomeField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o nome da empresa!\n");
            alert.showAndWait();
        } else if (cnpjField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o CNPJ da empresa!\n");
            alert.showAndWait();
        } else if (fantasiaField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o nome fantasia da empresa!\n");
            alert.showAndWait();
        } else if (emailField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o email da empresa!\n");
            alert.showAndWait();
        } else if (enderecoField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o endereço da empresa!\n");
            alert.showAndWait();
        } else if (foneField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o telefone da empresa!\n");
            alert.showAndWait();
        } else if (!foneField.getText().matches("[0-9]{10}") && !foneField.getText().matches("[0-9]{11}")) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RG inválido");
            alert.setHeaderText(null);
            alert.setContentText("Insira o Telefone com o DDD(Apenas numeros)!\nEx: 6599564016");
            alert.showAndWait();
        } else {

            Convenio novo = new Convenio(nomeField.getText() + "", fantasiaField.getText() + "",
                    cnpjField.getText() + "", foneField.getText() + "", emailField.getText() + "",
                    enderecoField.getText() + "");
            CCASS.dados.convenios.add(novo);
            ControladoraPrincipal.atualiza();
            closeButtonAction();
        }


    }

    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) nomeField.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
