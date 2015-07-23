package Bean;

/**
 *
 * @author Francisco Junior 23/07/2015
 */

public class ContatoBean {
    private int id;
    private String Nome;
    private String Endereco;
    private String Cidade;
    private String UF;
    private String email;
    private String telefone;
    private String celular;

    public ContatoBean() {
    }

    public ContatoBean(int id, String Nome, String Endereco, String Cidade, String UF, String email, String telefone, String celular) {
        this.id = id;
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.Cidade = Cidade;
        this.UF = UF;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
