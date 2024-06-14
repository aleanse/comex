package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Produto;

import javax.persistence.EntityManager;

public class JpaProdutoDao {
    private EntityManager em ;

    public JpaProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }
}
