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
    private final StringProperty TELProp;
    private String Nome;
    private String Pai;
    private String Mae;
    private String RG;
    private String CPF;
    private String TEL;
    private String Endereco;
    private ArrayList<Dependente> Dependentes = new ArrayList<Dependente>();

    public Associado(String nome, String CPF, String RG, String TEL, String endereco, String Pai, String Mae, ArrayList<Dependente> dependentes) {
        NomeProp = new SimpleStringProperty(nome);
        RGProp = new SimpleStringProperty(RG);
        CPFProp = new SimpleStringProperty(CPF);
        TELProp = new SimpleStringProperty(TEL);
        this.Nome = nome;
        CPF = CPF.replaceAll("[^0-9]", "");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1-$2");
        this.CPF = CPF;
        RG = RG.replaceAll("[^0-9]", "");
        RG = RG.replaceFirst("(\\d{7})(\\d)", "$1-$2");
        this.RG = RG;
        TEL = TEL.replaceAll("[^0-9]", "");
        TEL = TEL.replaceFirst("(\\d{2})(\\d)", "($1) $2");
        this.TEL = TEL;
        this.Pai = Pai;
        this.Mae = Mae;
        this.Endereco = endereco;
        this.Dependentes = dependentes;
    }

    public Associado(String nome, String CPF, String RG, String TEL, String Pai, String Mae, String endereco) {
        NomeProp = new SimpleStringProperty(nome);
        RGProp = new SimpleStringProperty(RG);
        CPFProp = new SimpleStringProperty(CPF);
        TELProp = new SimpleStringProperty(TEL);
        this.Nome = nome;
        CPF = CPF.replaceAll("[^0-9]", "");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1.$2");
        CPF = CPF.replaceFirst("(\\d{3})(\\d)", "$1-$2");
        this.CPF = CPF;
        RG = RG.replaceAll("[^0-9]", "");
        RG = RG.replaceFirst("(\\d{7})(\\d)", "$1-$2");
        this.RG = RG;
        TEL = TEL.replaceAll("[^0-9]", "");
        TEL = TEL.replaceFirst("(\\d{2})(\\d)", "($1) $2");
        this.TEL = TEL;
        this.Pai = Pai;
        this.Mae = Mae;
        this.Endereco = endereco;
    }


    @Override
    public String toString() {
        String aux = "";

        if (Dependentes.isEmpty()) {
            return Nome + ">" + CPF.replaceAll("[^0-9]", "") + ">" + RG.replaceAll("[^0-9]", "") +
                    ">" + TEL.replaceAll("[^0-9]", "") + ">" + Pai + ">"  + Mae + ">" + Endereco;
        } else {
            while (!Dependentes.isEmpty()) {
                aux += ">" + Dependentes.remove(0);
            }
            return Nome + ">" + CPF.replaceAll("[^0-9]", "") + ">" + RG.replaceAll("[^0-9]", "") +
                    ">" + TEL.replaceAll("[^0-9]", "") + ">" + Pai + ">"  + Mae + ">" + Endereco + aux;

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

    public void setTEL(String TEL) {
        TELProp.setValue(TEL);
        this.TEL = RG;
    }

    public String getTEL() {
        return TEL;
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
