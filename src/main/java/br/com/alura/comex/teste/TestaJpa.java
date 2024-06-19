package br.com.alura.comex.teste;

import br.com.alura.comex.dao.ProdutoDao;
import br.com.alura.comex.dao.jpa.JpaCategoriaDao;
import br.com.alura.comex.dao.jpa.JpaProdutoDao;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TestaJpa {

    public static void main(String[] args) {
        Categoria comida = new Categoria();
        comida.setDescricao("alimento");
        comida.setNome("comida");
        Produto churrasco = new Produto();
        churrasco.setDescricao("Muito bom");
        churrasco.setNome("churrasco");
        churrasco.setPreco(new BigDecimal(2000));
        churrasco.setCategoria(comida);


        EntityManager entityManager = JPAUtil.getEntityManager();
        JpaProdutoDao jpaProdutoDao = new JpaProdutoDao(entityManager);
        JpaCategoriaDao jpaCategoriaDao = new JpaCategoriaDao(entityManager);

        entityManager.getTransaction().begin();
        jpaCategoriaDao.cadastrar(comida);
        jpaProdutoDao.cadastrar(churrasco);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
