package br.com.alura.comex.model;

import javax.persistence.*;

@Entity  // indica que essa classe esta relacionada a uma tabela no db
@Table(name = "categorias")
public class Categoria {

    @Id  // indica que esse atributo é uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que é o banco de dados que vai gerar o ID
    private Long id;
    private String nome;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}