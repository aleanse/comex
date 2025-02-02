package aleanse.dao.jpa;

import aleanse.model.Pedido;
import aleanse.model.RelatorioDeVendasVo;


import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

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
    public BigDecimal valorTotalVendido(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql,BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendasVo> relatorioDeVendas(){
        String jpql = "SELECT new RelatorioDeVendasVo( " +
                "produto.nome, "+
                "SUM(item.quantidade), " +
                "MAX(pedido.data)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY SUM(item.quantidade) DESC ";
        return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
    }


}

