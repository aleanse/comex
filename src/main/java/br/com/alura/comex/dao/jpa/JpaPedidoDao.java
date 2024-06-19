package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.Produto;

import javax.persistence.EntityManager;

public class JpaPedidoDao {
    private EntityManager em ;

    public JpaPedidoDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void JpaPedidoDaoo(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido){
        this.em.persist(pedido);
    }

}
