package Control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * Created by thiago on 6/28/17.
 */
public class Associado {

    private final StringProperty NomeProp;
    private final StringProperty RGProp;
    private final StringProperty CPFProp;
    private final StringProperty TELProp;
    private String Nome;
    private String Pai;
    private String Mae;
    private String RG;
    private String CPF;
    private String Tel;
    private String Endereco;
    private Button Imprimir = new Button("dummy");
    private ArrayList<Dependente> Dependentes = new ArrayList<Dependente>();

    public Associado(String nome, String CPF, String RG, String Tel, String endereco, String Pai, String Mae, ArrayList<Dependente> dependentes) {
        NomeProp = new SimpleStringProperty(nome);
        RGProp = new SimpleStringProperty(RG);
        CPFProp = new SimpleStringProperty(CPF);
        TELProp = new SimpleStringProperty(Tel);
        this.Nome = nome;
        CPF = CPF.replaceAll("[^0-9]", "");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1-$2");
        this.CPF = CPF;
        RG = RG.replaceAll("[^0-9]", "");
        RG = RG.replaceFirst("(\\d{7})(\\d)", "$1-$2");
        this.RG = RG;
        Tel = Tel.replaceAll("[^0-9]", "");
        Tel = Tel.replaceFirst("(\\d{2})(\\d)", "($1) $2");
        this.Tel = Tel;
        this.Pai = Pai;
        this.Mae = Mae;
        this.Endereco = endereco;
        this.Dependentes = dependentes;
    }

    public Associado(String nome, String CPF, String RG, String Tel, String Pai, String Mae, String endereco) {
        NomeProp = new SimpleStringProperty(nome);
        RGProp = new SimpleStringProperty(RG);
        CPFProp = new SimpleStringProperty(CPF);
        TELProp = new SimpleStringProperty(Tel);
        this.Nome = nome;
        CPF = CPF.replaceAll("[^0-9]", "");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1-$2");
        this.CPF = CPF;
        RG = RG.replaceAll("[^0-9]", "");
        RG = RG.replaceFirst("(\\d{7})(\\d)", "$1-$2");
        this.RG = RG;
        Tel = Tel.replaceAll("[^0-9]", "");
        Tel = Tel.replaceFirst("(\\d{2})(\\d)", "($1) $2");
        this.Tel = Tel;
        this.Pai = Pai;
        this.Mae = Mae;
        this.Endereco = endereco;
    }


    @Override
    public String toString() {
        String aux = "";

        if (Dependentes.isEmpty()) {
            return Nome + ">" + CPF.replaceAll("[^0-9]", "") + ">" + RG.replaceAll("[^0-9]", "") +
                    ">" + Tel.replaceAll("[^0-9]", "") + ">" + Pai + ">"  + Mae + ">" + Endereco;
        } else {
            while (!Dependentes.isEmpty()) {
                aux += ">" + Dependentes.remove(0);
            }
            return Nome + ">" + CPF.replaceAll("[^0-9]", "") + ">" + RG.replaceAll("[^0-9]", "") +
                    ">" + Tel.replaceAll("[^0-9]", "") + ">" + Pai + ">"  + Mae + ">" + Endereco + aux;

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

    public void setTel(String tel) {
        TELProp.setValue(tel);
        this.Tel = RG;
    }

    public String getTel() {
        return Tel;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public ArrayList<Dependente> getDependentes() {
        return Dependentes;
    }

    public void setDependentes(ArrayList<Dependente> dependentes) {
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

    public StringProperty TELProp() {
        return TELProp;
    }


}
