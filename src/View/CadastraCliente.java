package View;

import Control.Associado;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

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
    private boolean novoAssociado(){

        if(nameField.getText().isEmpty()){
            System.out.println("Campo Obrigatório: Nome");
        }if(rgField.getText().isEmpty()){
            System.out.println("Campo Obrigatório: RG");
        }if(cpfField.getText().isEmpty()){
            System.out.println("Campo Obrigatório: CPF");
        }if(addrField.getText().isEmpty()){
            System.out.println("Campo Obrigatório: Endereço");
        }if(foneField.getText().isEmpty()){
            System.out.println("Campo Obrigatório: Telefone");
        }
        Associado novo = new Associado(nameField.getText(),cpfField.getText(),rgField.getText()+"-"+rgField2.getText(),
                addrField.getText(), new ArrayList<String>());

        System.out.println("tentando cadastrar novo Associado: "+nameField.getText());
        return true;
    }

}
