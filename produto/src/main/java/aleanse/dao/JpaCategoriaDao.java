package aleanse.dao;

import aleanse.model.Categoria;

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
    public List<Categoria> buscarTodasCategorias() {
        String jpql = "SELECT c FROM Categoria c";
        return em.createQuery(jpql, Categoria.class).getResultList();
    }
    public void deletarCategoriaPorId(Long id){
        Categoria categoria = em.find(Categoria.class, id);
        em.remove(categoria);
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
