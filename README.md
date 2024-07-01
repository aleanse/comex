
# Comex

## Descrição do Projeto

Projeto de sistema de gerenciamento de clientes, produtos e categorias desenvolvido em Java. Utiliza JPA (Java Persistence API) e Hibernate para a persistência de dados, proporcionando uma maneira eficiente e fácil de interagir com o banco de dados. Este projeto foi desenvolvido para praticar e demonstrar habilidades em desenvolvimento Java, incluindo o uso de JPA, Hibernate e configuração de projetos Java utilizando Maven.

## Funcionalidades

### Seção Cliente
- **Cadastrar Cliente**: Permite cadastrar um novo cliente.
- **Ver Clientes Cadastrados**: Exibe a lista de todos os clientes cadastrados no sistema.
- **Deletar Cliente**: Permite deletar um cliente existente.

### Seção Produto
- **Cadastrar Produto**: Permite cadastrar um novo produto.
- **Ver Produtos Cadastrados**: Exibe a lista de todos os produtos cadastrados no sistema.
- **Deletar Produto**: Permite deletar um produto existente.

### Seção Categoria
- **Cadastrar Categoria**: Permite cadastrar uma nova categoria.
- **Ver Categorias Cadastradas**: Exibe a lista de todas as categorias cadastradas no sistema.
- **Deletar Categoria**: Permite deletar uma categoria existente. Nota: Antes de deletar uma categoria, todos os produtos associados a ela devem ser deletados.

## Estrutura do Projeto

### JPA e Hibernate

#### JPA (Java Persistence API)
JPA é uma especificação Java que descreve uma interface comum para frameworks de persistência de dados. Ele define um conjunto de regras e padrões para mapeamento objeto-relacional (ORM), permitindo que desenvolvedores trabalhem com dados relacionais em uma abordagem orientada a objetos.

#### Hibernate
Hibernate é uma implementação da especificação JPA, fornecendo um framework robusto e poderoso para mapeamento objeto-relacional. Ele facilita a interação com o banco de dados, lidando automaticamente com operações CRUD e consultas complexas.

### Configuração do Projeto com Maven (`pom.xml`)

O arquivo `pom.xml` é utilizado pelo Maven para gerenciar as dependências do projeto e configurar o build. Inclui dependências como Hibernate, JPA e  MySQL Connector .

### Configuração do Banco de Dados (`persistence.xml`)

O arquivo `persistence.xml` contém as configurações necessárias para conectar o JPA ao banco de dados. Define o nome da unidade de persistência, o provedor, as classes de entidade e as propriedades de conexão, como URL, usuário, senha e dialeto do Hibernate.

## Entidades

### Cliente

A classe `Cliente` representa a entidade cliente no sistema. Cada cliente possui atributos como ID, CPF, nome, email, telefone, logradouro, cidade, estado e CEP. As anotações JPA, como `@Entity`, `@Table` e `@Id`, são usadas para mapear a classe para uma tabela no banco de dados e definir a chave primária.

### Categoria

A classe `Categoria` representa a entidade categoria no sistema. Cada categoria possui atributos como ID, nome e descrição. A anotação `@Entity` indica que a classe está mapeada para uma tabela no banco de dados, e `@GeneratedValue` define a estratégia de geração automática de IDs.

### Produto

A classe `Produto` representa a entidade produto no sistema. Cada produto possui atributos como ID, nome, descrição, data de cadastro, preço e uma relação `@ManyToOne` com a categoria. A anotação `@ManyToOne` indica uma relação de muitos para um entre produto e categoria.

## DAOs (Data Access Objects)

Os DAOs são responsáveis por encapsular a lógica de acesso ao banco de dados. Cada entidade possui um DAO correspondente, como `JpaClienteDao`, `JpaCategoriaDao` e `JpaProdutoDao`, que fornecem métodos para operações CRUD (Create, Read, Update, Delete).

### JpaClienteDao

- **cadastrar(Cliente cliente)**: Persiste um novo cliente no banco de dados.
- **buscarTodosClientes()**: Retorna uma lista de todos os clientes cadastrados.
- **deletarClientePorId(Long id)**: Deleta um cliente pelo ID.
- **atualizar(Cliente cliente)**: Atualiza um cliente existente.

### JpaCategoriaDao

- **cadastrar(Categoria categoria)**: Persiste uma nova categoria no banco de dados.
- **buscarTodasCategorias()**: Retorna uma lista de todas as categorias cadastradas.
- **deletarCategoriaPorId(Long id)**: Deleta uma categoria pelo ID.
- **atualizar(Categoria categoria)**: Atualiza uma categoria existente.

### JpaProdutoDao

- **cadastrar(Produto produto)**: Persiste um novo produto no banco de dados.
- **buscarTodosProdutos()**: Retorna uma lista de todos os produtos cadastrados.
- **deletarProdutoPorId(Long id)**: Deleta um produto pelo ID.
- **atualizar(Produto produto)**: Atualiza um produto existente.

## Conclusão

O projeto Comex demonstra a utilização de JPA e Hibernate para gerenciamento de persistência em uma aplicação Java. Com a configuração adequada do Maven e do `persistence.xml`, o sistema é capaz de realizar operações CRUD de maneira eficiente e organizada. As classes de entidade e os DAOs proporcionam uma estrutura clara e funcional para o desenvolvimento de aplicações robustas e escaláveis.

