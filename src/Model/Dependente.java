package Model;

/**
 * Created by thiago on 7/4/17.
 */
public class Dependente {

    private String nome;
    private String documento;

    public Dependente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

}
