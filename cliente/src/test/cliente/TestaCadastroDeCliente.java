package br.com.alura.comex.teste.cliente;

import br.com.alura.comex.model.Cliente;

public class TestaCadastroDeCliente {

    public static void main(String[] args) {
        Cliente novoCliente = new Cliente("Grupo Quem Disse que Acabou","666.777.888-99");
        novoCliente.setEmail("grupoqdqa@gmail.com");
        novoCliente.setTelefone("(61) 98448-1019");
        novoCliente.setLogradouro("Deck Bar");
        novoCliente.setCidade("Águas Claras");
        novoCliente.setEstado("DF");
        novoCliente.setCep("72000-000");

        ClienteService service = new ClienteService();
        service.efetuaCadastroDeCliente(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }
}
