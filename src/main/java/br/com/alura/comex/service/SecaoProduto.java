package br.com.alura.comex.service;

import br.com.alura.comex.dao.jpa.JpaClienteDao;
import br.com.alura.comex.dao.jpa.JpaProdutoDao;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class SecaoProduto {
    static EntityManager em;
    Scanner scanner = new Scanner(System.in);

    public SecaoProduto(EntityManager entityManager) {
        this.em = entityManager;

    }
    public void cadastraProduto() {
        JpaProdutoDao jpaProdutoDao = new JpaProdutoDao(em);
        System.out.println("nome:");
        String nome = scanner.next();
        System.out.println("preço:");
        BigDecimal preco = scanner.nextBigDecimal();
        SecaoCategoria secaoCategoria = new SecaoCategoria(em);
        Categoria categoria;
        while (true) {
            System.out.print("Categoria: ");
            String opc = scanner.next();
            categoria = secaoCategoria.categoriaExiste(opc);
            if (categoria != null) {
                break;

            } else {
                System.out.println("Categoria " + opc + " não encontrada. Tente novamente.");
            }
        }
        System.out.println(categoria);
        Produto produto = new Produto(nome, preco, categoria);
        System.out.println("digite a descrição ou [1] para finalizar");
        String item = scanner.next();
        int opcao = 0;
        while (true){
            try {
                opcao = Integer.parseInt(item);

            } catch (NumberFormatException e) {
            }
            if (opcao == 1) {
                break;
            } else {
                produto.setDescricao(item);
                break;
            }
        }
        em.getTransaction().begin();
        jpaProdutoDao.cadastrar(produto);
        em.getTransaction().commit();
        System.out.println("produto cadastrado com sucesso!");

    }
    public void imprimirProdutos () {
        JpaProdutoDao jpaProdutoDao = new JpaProdutoDao(em);
        List<Produto> listaProduto = jpaProdutoDao.buscarTodosProdutos();
        System.out.println("Lista de Clientes:");
        for (Produto produto : listaProduto) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("---------------------------------------");
        }
    }

        public void deletarClientes () {
            JpaClienteDao jpaClienteDao = new JpaClienteDao(em);
            List<Cliente> listaClientes = jpaClienteDao.buscarTodosClientes();
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : listaClientes) {
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("---------------------------------------");
            }
            Long opc;
            while (true) {
                System.out.print("Digite o ID do cliente que deseja deletar: ");
                opc = scanner.nextLong();
                if (SecaoCliente.clienteExiste(opc)) {
                    break;
                } else {
                    System.out.println("Cliente com ID " + opc + " não encontrado. Tente novamente.");
                }
            }
            em.getTransaction().begin();
            jpaClienteDao.deletarClientePorId(opc);
            System.out.println("Cliente deletado com sucesso");
            em.getTransaction().commit();
        }
    }
