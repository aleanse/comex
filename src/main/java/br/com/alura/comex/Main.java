package br.com.alura.comex;

import br.com.alura.comex.dao.jpa.JpaClienteDao;
import br.com.alura.comex.dao.jpa.JpaProdutoDao;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;
        while (opcao != 0){
            System.out.println("BEM VINDO AO COMEX,ESCOLHA UMA DAS OPÇÕES ABAIXO");
            System.out.println("""
                [1] Cadastrar cliente
                [2] Ver clientes cadastrados
                [3] Deletar clientes
                [4] Cadastrar produto
                [5] Ver produtos
                [6] Deletar produtos
                [7] Cadastrar categoria
                [8] Ver categorias
                [0] Finalizar""");
            opcao = scanner.nextInt();
            if (opcao == 1 ){
                JpaClienteDao jpaClienteDao = new JpaClienteDao(entityManager);
                System.out.println("nome do cliente:");
                String nome = scanner.next();
                System.out.println("cpf do cliente:");
                String cpf = scanner.next();
                Cliente cliente = new Cliente(nome,cpf);
                entityManager.getTransaction().begin();
                jpaClienteDao.cadastrar(cliente);
                entityManager.getTransaction().commit();
                System.out.println("Cliente cadastrado com sucesso!");
                System.out.println("""
                        [1] Voltar a tela inicial?
                        [2] Finalizar
                        [3] cadastrar mais dados do cliente?""");
                opcao = scanner.nextInt();
                if(opcao == 1){
                    continue;
                }
                if(opcao == 2){
                    entityManager.close();
                    break;
                }
                if (opcao == 3){
                    System.out.println("Email:");
                    String email = scanner.next();
                    cliente.setEmail(email);
                    System.out.println("Telefone:");
                    String telefone = scanner.next();
                    cliente.setTelefone(telefone);
                    System.out.println("Logradouro:");
                    String logradouro = scanner.next();
                    cliente.setLogradouro(logradouro);
                    System.out.println("Cidade:");
                    String cidade = scanner.next();
                    cliente.setCidade(cidade);
                    System.out.println("Estado:");
                    String estado = scanner.next();
                    cliente.setEstado(estado);
                    System.out.println("Cep");
                    String cep = scanner.next();
                    cliente.setCep(cep);
                    entityManager.getTransaction().begin();
                    jpaClienteDao.cadastrar(cliente);
                    entityManager.getTransaction().commit();
                    System.out.println("Cliente cadastrado por completo");
                    continue;
                }
            }
        entityManager.close();
        }

    }
}
