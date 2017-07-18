package Control;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Simple model class for the person table.
 *
 * @author Marco Jakob
 */
public class Pessoa {

    private final StringProperty Nome;
    private final StringProperty CPF;
    private final StringProperty RG;
    private final StringProperty TEL;

    public Pessoa(String Nome, String CPF, String RG, String TEL) {
        this.Nome = new SimpleStringProperty(Nome);
        this.CPF = new SimpleStringProperty(CPF);
        this.RG = new SimpleStringProperty(RG);
        this.TEL = new SimpleStringProperty(TEL);
    }

    public String getNome() {
        return Nome.get();
    }

    public StringProperty nomeProperty() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome.set(nome);
    }

    public String getCPF() {
        return CPF.get();
    }

    public StringProperty CPFProperty() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF.set(CPF);
    }

    public String getRG() {
        return RG.get();
    }

    public StringProperty RGProperty() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG.set(RG);
    }

    public String getTEL() {
        return TEL.get();
    }

    public StringProperty TELProperty() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL.set(TEL);
    }
}