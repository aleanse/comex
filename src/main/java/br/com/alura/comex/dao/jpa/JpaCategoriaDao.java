package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaCategoriaDao {
    private EntityManager em ;

    public JpaCategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria){

        this.em.persist(categoria);
    }
    public void atualizar(Categoria categoria){
        this.em.merge(categoria);
    }
    public void remove(Categoria categoria){
        categoria = em.merge(categoria);
        em.remove(categoria);

        this.em.merge(categoria);
    }
    public Categoria buscaPorId(Long id){
        return  em.find(Categoria.class,id);
    }

}
