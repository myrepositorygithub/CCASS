package Control;

import java.util.ArrayList;

/**
 * Created by thiago on 6/28/17.
 */
public class Associado {

    private String Nome;
    private String CPF;
    private String RG;
    private String Endereco;
    private ArrayList<String> Dependentes;

    public Associado(String nome, String CPF, String RG, String endereco, ArrayList<String> dependentes) {
        Nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        Endereco = endereco;
        Dependentes = dependentes;
    }


    @Override
    public String toString() {
        String aux = "";

        if (Dependentes.isEmpty()) {
            return  Nome + "-" + CPF + "-" + RG + "-" + Endereco ;
        } else {
            while (!Dependentes.isEmpty()) {
                aux += "-" + Dependentes.remove(0);
            }
            return Nome + "-" + CPF + "-" + RG + "-" + Endereco + aux ;

        }
    }


}
