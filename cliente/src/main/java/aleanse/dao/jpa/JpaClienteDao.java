package aleanse.dao.jpa;


import aleanse.model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaClienteDao {
    private EntityManager em ;

    public JpaClienteDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void JpaPedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public List<Cliente> buscarTodosClientes() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public void deletarClientePorId(Long id){
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
    }

    public void atualizar(Cliente cliente){
        this.em.merge(cliente);
    }
}
