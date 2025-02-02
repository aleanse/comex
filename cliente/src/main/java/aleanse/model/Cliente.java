package aleanse.model;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id  // indica que esse atributo é uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que é o banco de dados que vai gerar o ID
    private Long id;

    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;
    public Cliente(String nome, String cpf)
    {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(){

    }



    public Long getId() {
        return id;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
