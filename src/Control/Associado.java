package Control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Created by thiago on 6/28/17.
 */
public class Associado {

    private final StringProperty NomeProp;
    private final StringProperty RGProp;
    private final StringProperty CPFProp;
    private String Nome;
    private String RG;
    private String CPF;
    private String Endereco;
    private ArrayList<String> Dependentes;

    public Associado(String nome, String CPF, String RG, String endereco, ArrayList<String> dependentes) {
        NomeProp = new SimpleStringProperty(nome);
        RGProp = new SimpleStringProperty(RG);
        CPFProp = new SimpleStringProperty(CPF);
        this.Nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.Endereco = endereco;
        this.Dependentes = dependentes;
    }


    @Override
    public String toString() {
        String aux = "";

        if (Dependentes.isEmpty()) {
            return Nome + "-" + CPF + "-" + RG + "-" + Endereco;
        } else {
            while (!Dependentes.isEmpty()) {
                aux += "-" + Dependentes.remove(0);
            }
            return Nome + "-" + CPF + "-" + RG + "-" + Endereco + aux;

        }
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        NomeProp.setValue(nome);
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        CPFProp.setValue(CPF);
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        RGProp.setValue(RG);
        this.RG = RG;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public ArrayList<String> getDependentes() {
        return Dependentes;
    }

    public void setDependentes(ArrayList<String> dependentes) {
        Dependentes = dependentes;
    }

    public StringProperty NomeProp() {
        return NomeProp;
    }

    public StringProperty RGProp() {
        return RGProp;
    }

    public StringProperty CPFProp() {
        return CPFProp;
    }


}
