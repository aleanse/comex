package br.com.alura.comex.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal valorTotal;
    private LocalDate data = LocalDate.now();

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(){

    }

    public Pedido(Cliente cliente){
        this.cliente = cliente;

    }
    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itens.add(item);
    }

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

    public BigDecimal getPreco() {
        return valorTotal;
    }

    public void setPreco(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}