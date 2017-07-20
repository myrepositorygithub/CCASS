package Model;

/**
 * Created by thiago on 7/4/17.
 */
public class Convenio {

    private String Nome;
    private String Fantasia;
    private String CNPJ;
    private String Tel;
    private String Email;
    private String Endereco;


    public Convenio(String nome, String fantasia, String CNPJ, String tel, String email, String endereco) {
        Nome = nome;
        Fantasia = fantasia;
        this.CNPJ = CNPJ;
        Tel = tel;
        Email = email;
        Endereco = endereco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getFantasia() {
        return Fantasia;
    }

    public void setFantasia(String fantasia) {
        Fantasia = fantasia;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }
}
