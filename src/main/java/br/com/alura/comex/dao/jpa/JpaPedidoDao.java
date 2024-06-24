package br.com.alura.comex.dao.jpa;

import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.model.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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
        String jpql = "SELECT new br.com.alura.comex.model.RelatorioDeVendasVo( " +
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
    public List<Produto> buscarPorParametros(String nome,
                                             BigDecimal preco,
                                             LocalDate dataCadastro){
        CriteriaBuilder builder =  em.getCriteriaBuilder();
        CriteriaQuery<Produto> query =  builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);



    }


}

