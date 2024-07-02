package aleanse.service;

import aleanse.dao.JpaCategoriaDao;
import aleanse.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class SecaoCategoria {
    static EntityManager em;
    Scanner scanner = new Scanner(System.in);
    public SecaoCategoria(EntityManager entityManager) {
        this.em = entityManager;

    }
    public void cadastraCategoria() {
        JpaCategoriaDao jpaCategoriaDao = new JpaCategoriaDao(em);
        System.out.println("nome:");
        String nome = scanner.next();
        System.out.println("descrição:");
        String descricao = scanner.next();
        Categoria categoria = new Categoria(nome,descricao);
        em.getTransaction().begin();
        jpaCategoriaDao.cadastrar(categoria);
        em.getTransaction().commit();
        System.out.println("Categoria cadastrado com sucesso!");
    }
    public void imprimirCategorias() {
        JpaCategoriaDao jpaCategoriaDao = new JpaCategoriaDao(em);
        List<Categoria> listaCategorias = jpaCategoriaDao.buscarTodasCategorias();
        System.out.println("Lista de categorias:");
        for (Categoria categoria : listaCategorias) {
            System.out.println("ID: " + categoria.getId());
            System.out.println("Nome: " + categoria.getNome());
            System.out.println("Descrição: " + categoria.getDescricao());
            System.out.println("---------------------------------------");
        }
    }
    public static boolean categoriaExiste(Long opc){
        Categoria categoria = em.find(Categoria.class, opc);
        return categoria != null;
    }

    public void deletarCategoria() {
        JpaCategoriaDao jpaCategoriaDao = new JpaCategoriaDao(em);
        List<Categoria> listaCategorias = jpaCategoriaDao.buscarTodasCategorias();
        System.out.println("Lista de Categorias:");
        for (Categoria categoria : listaCategorias) {
            System.out.println("ID: " + categoria.getId());
            System.out.println("Nome: " + categoria.getNome());
            System.out.println("Descrição: " + categoria.getDescricao());
            System.out.println("---------------------------------------");
        }
        Long opc;
        while (true) {
            System.out.print("Digite o ID da Categoria que deseja deletar: ");
            opc = scanner.nextLong();
            if (SecaoCategoria.categoriaExiste(opc)) {
                break;
            } else {
                System.out.println("Categoria com ID " + opc + " não encontrada. Tente novamente.");
            }
        }
        em.getTransaction().begin();
        jpaCategoriaDao.deletarCategoriaPorId(opc);
        System.out.println("Categoria deletada com sucesso");
        em.getTransaction().commit();
    }
    public Categoria categoriaExiste(String nome){
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
