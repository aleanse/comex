package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaProdutoDao {
    private EntityManager em ;

    public JpaProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }
    public void atualizar(Produto produto){
        this.em.merge(produto);
    }
    public void remover(Produto produto){
        produto = em.merge(produto);

        this.em.remove(produto);
    }
    public Produto buscaPorId(Long id){
        return em.find(Produto.class,id);
    }
}
