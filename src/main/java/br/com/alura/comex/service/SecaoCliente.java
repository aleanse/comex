package br.com.alura.comex.service;

import br.com.alura.comex.dao.jpa.JpaClienteDao;
import br.com.alura.comex.model.Cliente;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SecaoCliente {

    static EntityManager em;
    Scanner scanner = new Scanner(System.in);

    public SecaoCliente(EntityManager entityManager) {
        this.em = entityManager;

    }

    public void cadastraCliente() {
        JpaClienteDao jpaClienteDao = new JpaClienteDao(em);
        System.out.println("nome:");
        String nome = scanner.next();
        System.out.println("cpf:");
        String cpf = scanner.next();
        Cliente cliente = new Cliente(nome, cpf);
        while (true) {
            System.out.println("digite o email ou [1] para finalizar");
            String item = scanner.next();
            int opcao = 0;
            try {
                opcao = Integer.parseInt(item);

            } catch (NumberFormatException e) {
            }
            if (opcao == 1) {
                break;
            } else {
                cliente.setEmail(item);
            }
            System.out.println("digite o telefone ou [1] para finalizar");
            item = scanner.next();
            try {
                opcao = Integer.parseInt(item);

            } catch (NumberFormatException e) {
            }
            if (opcao == 1) {
                break;
            } else {
                cliente.setTelefone(item);
            }
            System.out.println("digite o logradouro ou [1] para finalizar");
            item = scanner.next();
            try {
                opcao = Integer.parseInt(item);

            } catch (NumberFormatException e) {
            }
            if (opcao == 1) {
                break;
            } else {
                cliente.setLogradouro(item);
            }

            System.out.println("digite a cidade ou [1] para finalizar");
            item = scanner.next();
            try {
                opcao = Integer.parseInt(item);

            } catch (NumberFormatException e) {
            }
            if (opcao == 1) {
                break;
            } else {
                cliente.setCidade(item);
            }

            System.out.println("digite o estado ou [1] para finalizar");
            item = scanner.next();
            try {
                opcao = Integer.parseInt(item);

            } catch (NumberFormatException e) {
            }
            if (opcao == 1) {
                break;
            } else {
                cliente.setEstado(item);
            }
            System.out.println("digite o cep ou [1] para finalizar");
            item = scanner.next();
            try {
                opcao = Integer.parseInt(item);

            } catch (NumberFormatException e) {
            }
            if (opcao == 1) {
                break;
            } else {
                cliente.setCep(item);
                break;
            }
        }
        em.getTransaction().begin();
        jpaClienteDao.cadastrar(cliente);
        em.getTransaction().commit();
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void imprimirClientes() {
        JpaClienteDao jpaClienteDao = new JpaClienteDao(em);
        List<Cliente> listaClientes = jpaClienteDao.buscarTodosClientes();
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Logradouro: " + cliente.getLogradouro());
            System.out.println("Cidade: " + cliente.getCidade());
            System.out.println("Estado: " + cliente.getEstado());
            System.out.println("CEP: " + cliente.getCep());
            System.out.println("---------------------------------------");
        }
    }
    public static boolean clienteExiste(Long opc){
        Cliente cliente = em.find(Cliente.class, opc);
        return cliente != null;
    }

    public void deletarClientes() {
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
