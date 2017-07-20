package Control;

import javafx.fxml.FXML;
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

        } else if (cnpjField.getText().isEmpty()) {

        } else if (fantasiaField.getText().isEmpty()) {

        } else if (emailField.getText().isEmpty()) {

        } else if (enderecoField.getText().isEmpty()) {

        } else if (foneField.getText().isEmpty()) {

        } else {

            Convenio novo = new Convenio(nomeField.getText() + "", fantasiaField.getText() + "",
                    cnpjField.getText() + "", foneField.getText() + "", emailField.getText() + "",
                    enderecoField.getText() + "");
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
