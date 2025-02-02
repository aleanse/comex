package aleanse.dao;


import aleanse.banco.ConnectionFactory;
import aleanse.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    public List<Cliente> listaTodos() {
        String sql = "select * from cliente";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection conexao = connectionFactory.criaConexao()) {
            PreparedStatement preparoDoComando = conexao.prepareStatement(sql);
            ResultSet resultSet = preparoDoComando.executeQuery();

            List<Cliente> lista = new ArrayList<>();
            while (resultSet.next()) {
                lista.add(montaCliente(resultSet));
            }

            preparoDoComando.close();
            resultSet.close();

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Cliente montaCliente(ResultSet resultSet) throws SQLException {
        Cliente cliente = new Cliente("nome","cpf");
        cliente.setEmail(resultSet.getString("email"));
        cliente.setTelefone(resultSet.getString("telefone"));
        cliente.setLogradouro(resultSet.getString("logradouro"));
        cliente.setCidade(resultSet.getString("cidade"));
        cliente.setEstado(resultSet.getString("estado"));
        cliente.setCep(resultSet.getString("cep"));

        return cliente;
    }

    public void cadastra(Cliente cliente) {
        String sql = """
                     insert into cliente 
                        (nome, email, telefone, cpf, logradouro,cidade,estado,cep) 
                     values
                        (?, ?, ?, ?, ?, ?,?, ?)
                     """;

        try (Connection conexao = new ConnectionFactory().criaConexao()) {
            PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getCpf());
            comando.setString(5, cliente.getLogradouro());
            comando.setString(7, cliente.getCidade());
            comando.setString(8, cliente.getEstado());
            comando.setString(9, cliente.getCep());
            comando.execute();
            comando.close();
        } catch (SQLException e) {
            throw new RuntimeException("Deu merda na hora de salvar...", e);
        }
    }

    public void exclui(Cliente cliente) {
        String sql = "delete from cliente where id = ?";

        try (Connection conexao = new ConnectionFactory().criaConexao()) {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, cliente.getId());

            comando.execute();
            comando.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente.", e);
        }
    }

    public void atualiza(Cliente cliente) {
        String sql = """
                     update cliente set 
                        nome = ?, 
                        email = ?, 
                        telefone = ?, 
                        cpf = ?, 
                        logradouro = ?, 
                        cidade = ?, 
                        cep = ? 
                     where id = ?
                     """;

        try (Connection conexao = new ConnectionFactory().criaConexao()) {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getCpf());
            comando.setString(5, cliente.getLogradouro());
            comando.setString(7, cliente.getCidade());
            comando.setString(8, cliente.getEstado());
            comando.setString(9, cliente.getCep());
            comando.setLong(10, cliente.getId());

            comando.execute();
            comando.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente.", e);
        }
    }

    public Cliente pesquisaPeloId(long id) {
        String sql = "select * from cliente where id = ?";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection conexao = connectionFactory.criaConexao()) {
            PreparedStatement preparoDoComando = conexao.prepareStatement(sql);
            preparoDoComando.setLong(1, id);

            ResultSet resultSet = preparoDoComando.executeQuery();

            Cliente possivelCliente = null;
            if (resultSet.next()) {
                possivelCliente = montaCliente(resultSet);
            }

            preparoDoComando.close();
            resultSet.close();

            return possivelCliente;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar cliente por ID", e);
        }
    }
}
