package br.com.alura.comex;

import br.com.alura.comex.dao.jpa.JpaClienteDao;
import br.com.alura.comex.dao.jpa.JpaProdutoDao;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.service.SecaoCliente;
import br.com.alura.comex.service.SecaoProduto;
import br.com.alura.comex.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;
        System.out.println("BEM VINDO AO COMEX,ESCOLHA UMA DAS OPÇÕES ABAIXO");
        while (opcao != 0){
            System.out.println("""
                [1] Seção cliente             
                [2] Seção produto
                [5] Ver produtos
                [6] Deletar produtos
                [7] Cadastrar categoria
                [8] Ver categorias
                [0] Finalizar
                """);
            opcao = scanner.nextInt();
            if (opcao == 1 ){
                System.out.println("""
                        [1] Cadastrar cliente
                        [2] Ver clientes cadastrados
                        [3] Deletar cliente
                        [0] Finalizar
                        """);
                opcao = scanner.nextInt();
                if(opcao == 1){
                    SecaoCliente secaoCliente = new SecaoCliente(entityManager);
                    secaoCliente.cadastraCliente();
                }
                if(opcao == 2){
                    SecaoCliente secaoCliente = new SecaoCliente(entityManager);
                    secaoCliente.imprimirClientes();

                }
                if(opcao == 3){
                    SecaoCliente secaoCliente = new SecaoCliente(entityManager);
                    secaoCliente.deletarClientes();

                }
                if(opcao == 0){
                    break;
                }
                System.out.println("""
                        [1] Voltar a tela inicial?
                        [2] Finalizar
                        """);
                opcao = scanner.nextInt();
                if(opcao == 1){
                    continue;
                }
                if(opcao == 2){
                    entityManager.close();
                    break;
                }
                }
            if (opcao == 2){
                System.out.println("""
                        [1] Cadastrar Produto
                        [2] Ver produtos cadastrados
                        [3] Deletar produto
                        [0] Finalizar
                        """);
                opcao = scanner.nextInt();
                SecaoProduto secaoProduto = new SecaoProduto(entityManager);
                if(opcao == 1){
                    secaoProduto.cadastraProduto();
                }
                if(opcao == 2 ){
                    secaoProduto.imprimirProdutos();
                }
                if(opcao == 0){
                    break;
                }
                System.out.println("""
                        [1] Voltar a tela inicial?
                        [2] Finalizar
                        """);
                opcao = scanner.nextInt();
                if(opcao == 1){
                    continue;
                }
                if(opcao == 2){
                    entityManager.close();
                    break;
                }

            }
            if (opcao == 0){
                break;
            }
            }
        entityManager.close();
        }
    }

