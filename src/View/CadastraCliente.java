package View;

import Control.Associado;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by thiago on 6/28/17.
 */
public class CadastraCliente {

    @FXML
    private TextField nameField;
    @FXML
    private TextField rgField;
    @FXML
    private TextField rgField2;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField addrField;
    @FXML
    private TextField foneField;
    @FXML
    private TextField emailField;
    @FXML
    private Button cadastra;
    @FXML
    private Button cancela;
    @FXML
    private Button addDependent;

    @FXML
    private void novoAssociado() {

        if (nameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o nome completo!\n");
            alert.showAndWait();
            System.out.println("Campo Obrigatório: Nome");
        } else if (!rgField.getText().matches("[0-9]{8}")) {
            if (rgField.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Campo Obrigatório");
                alert.setHeaderText(null);
                alert.setContentText("Insira os 8 digitos do RG!\nEx: 12345678");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("RG inválido");
                alert.setHeaderText(null);
                alert.setContentText("Insira apenas os 8 digitos!\nEx: 12345678");
                alert.showAndWait();
            }
            System.out.println("Campo Obrigatório: RG");
        } else if (!cpfField.getText().matches("[0-9]{11}")) {
            if (cpfField.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Campo Obrigatório");
                alert.setHeaderText(null);
                alert.setContentText("Insira os 11 digitos do CPF!\nEx: 12345678911");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CPF inválido");
                alert.setHeaderText(null);
                alert.setContentText("Insira apenas os 11 digitos.\nEx: 12345678911");
                alert.showAndWait();
            }
            System.out.println("Campo Obrigatório: CPF");
        } else if (addrField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o Endereço!\n");

            alert.showAndWait();
            System.out.println("Campo Obrigatório: Endereço");
        } else if (foneField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo Obrigatório");
            alert.setHeaderText(null);
            alert.setContentText("Insira o Telefone de contato!\n");

            alert.showAndWait();
            System.out.println("Campo Obrigatório: Telefone");
        } else if (!foneField.getText().matches("[0-9]{10}") && !foneField.getText().matches("[0-9]{11}")) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("RG inválido");
            alert.setHeaderText(null);
            alert.setContentText("Insira o Telefone com o DDD(Apenas numeros)!\nEx: 6599564016");
            alert.showAndWait();
        } else {
            String rg = rgField.getText().substring(0, 7) + "-" + rgField.getText().charAt(7);

            String cpf = cpfField.getText().substring(0, 3) + "." + cpfField.getText().substring(3, 6) + "." +
                    cpfField.getText().substring(6, 9) + "-" + cpfField.getText().substring(9, 11);
            String phone = "("+foneField.getText().substring(0,2) +")"+ foneField.getText().substring(2);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Detalhes do associado");
            alert.setContentText("Nome: \t\t" + nameField.getText() + "\n" +
                    "RG: \t\t\t" + rg + " " + rgField2.getText() + "\n" +
                    "CPF: \t\t\t" + cpf + "\n" +
                    "Endereço: \t" + addrField.getText() + "\n" +
                    "Telefone: \t\t" + phone + "\n" +
                    "Dependentes: \t" + "\n");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ... user chose OK
                Associado novo = new Associado(nameField.getText(), cpfField.getText(), rgField.getText() + "-" + rgField2.getText(),
                        addrField.getText(), new ArrayList<String>());

                System.out.println("tentando cadastrar novo Associado: " + nameField.getText());
                closeButtonAction();
            }
        }
    }


    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) cancela.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
