package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Pedido;

import javax.persistence.EntityManager;

public class JpaClienteDao {
    private EntityManager em ;

    public JpaClienteDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void JpaPedidoDaoo(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }
}
