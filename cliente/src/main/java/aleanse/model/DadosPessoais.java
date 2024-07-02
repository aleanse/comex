package aleanse.model;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
    private String cpf;
    private String nome;

    public DadosPessoais(String nome, String cpf) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
