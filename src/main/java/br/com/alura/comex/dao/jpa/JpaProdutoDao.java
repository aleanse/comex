package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaProdutoDao {
    private  EntityManager em ;

    public JpaProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }
    public List<Produto> buscarTodosProdutos() {
        String jpql = "SELECT c FROM Produto c";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
    public void deletarClientePorId(Long id){
        Produto produto = em.find(Produto.class, id);
        em.remove(produto);
    }
    public void atualizar(Produto produto){
        this.em.merge(produto);
    }
    public void remover(Produto produto){
        produto = em.merge(produto);

        this.em.remove(produto);
    }
    public void deletarProdutoPorId(Long id){
        Produto produto = em.find(Produto.class, id);
        em.remove(produto);
    }
    public  Produto buscaPorId(Long id){
        return em.find(Produto.class,id);
    }
}
