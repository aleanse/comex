package br.com.alura.comex.service;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class SecaoCategoria {
    static EntityManager em;
    Scanner scanner = new Scanner(System.in);
    public SecaoCategoria(EntityManager entityManager) {
        this.em = entityManager;

    }
    public  Categoria categoriaExiste(String nome){
        String jpql = "SELECT c FROM Categoria c WHERE c.nome = :nome";
        List<Categoria> resultados = em.createQuery(jpql, Categoria.class)
                .setParameter("nome", nome)
                .getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }
}
