package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;

import javax.persistence.EntityManager;

public class JpaCategoriaDao {
    private EntityManager em ;

    public JpaCategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }

}
