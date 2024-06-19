package br.com.alura.comex.teste;

import br.com.alura.comex.dao.ProdutoDao;
import br.com.alura.comex.dao.jpa.JpaCategoriaDao;
import br.com.alura.comex.dao.jpa.JpaClienteDao;
import br.com.alura.comex.dao.jpa.JpaPedidoDao;
import br.com.alura.comex.dao.jpa.JpaProdutoDao;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.model.ItemPedido;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.utils.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TestaCadastroJpa {
    public static void main(String[] args) {
        Cadastrar();
        EntityManager entityManager = JPAUtil.getEntityManager();
        JpaProdutoDao jpaProdutoDao = new JpaProdutoDao(entityManager);
        Produto produto = jpaProdutoDao.buscaPorId(1l);
        Cliente cliente = new Cliente();
        cliente.setNome("aleanse");
        cliente.setEstado("Ma");
        cliente.setCep("43224");
        cliente.setCpf("029384");
        cliente.setCidade("são-luis");
        cliente.setLogradouro("condominio");
        cliente.setEmail("aleanselima@gmail.com");
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10,pedido,produto));
        JpaPedidoDao jpaPedidoDao = new JpaPedidoDao(entityManager);
        entityManager.getTransaction().begin();

        JpaClienteDao jpaClienteDao = new JpaClienteDao(entityManager);
        jpaClienteDao.cadastrar(cliente);

        jpaPedidoDao.cadastrar(pedido);
        entityManager.getTransaction().commit();
        entityManager.close();




    }
    public static void Cadastrar(){
        Categoria roupa = new Categoria();
        roupa.setDescricao("tecidos");
        roupa.setNome("roupa");
        Produto camisa = new Produto();
        camisa.setDescricao("Muito bom");
        camisa.setNome("churrasco");
        camisa.setPreco(new BigDecimal(2000));
        camisa.setCategoria(roupa);
        EntityManager entityManager = JPAUtil.getEntityManager();
        JpaProdutoDao jpaProdutoDao = new JpaProdutoDao(entityManager);
        JpaCategoriaDao jpaCategoriaDao = new JpaCategoriaDao(entityManager);
        entityManager.getTransaction().begin();
        jpaCategoriaDao.cadastrar(roupa);
        jpaProdutoDao.cadastrar(camisa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}