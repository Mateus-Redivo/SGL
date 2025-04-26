# Sistema de Gerenciamento de Livros (SGL)

Este é um projeto simples em Java para gerenciar livros, usuários e empréstimos em uma biblioteca. Ele foi desenvolvido com o objetivo de demonstrar conceitos básicos de programação orientada a objetos, como encapsulamento, herança e composição, além de boas práticas de organização de código.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

### Descrição dos Diretórios

- **src/main/java/com/SGL/controller/**: Contém as classes responsáveis pela lógica de controle, como gerenciar empréstimos, usuários e livros.
- **src/main/java/com/SGL/model/**: Contém as classes que representam os modelos de dados, como `Livro`, `Usuario` e `Emprestimo`.
- **src/main/java/com/SGL/view/**: Contém as classes responsáveis pela exibição de informações, como a `LivroView`.
- **src/main/java/com/SGL/app/Main.java**: Classe principal que inicializa o sistema e gerencia a interface com o usuário.

## Funcionalidades

### Gerenciamento de Usuários
- Adicionar novos usuários.
- Buscar usuários pelo ID.
- Listar todos os usuários cadastrados.

### Gerenciamento de Livros
- Adicionar novos livros com título, autor e ano de publicação.
- Listar todos os livros cadastrados.

### Gerenciamento de Empréstimos
- Realizar empréstimos de livros para usuários.
- Definir datas de empréstimo e devolução.
- Listar todos os empréstimos ativos.
- Buscar empréstimos por usuário.

## Classes Principais

### `UsuarioController`
Gerencia as operações relacionadas aos usuários, como cadastro, busca e listagem. Mantém uma lista de usuários e oferece métodos para adicionar, buscar e listar usuários.

### `LivroController`
Gerencia as operações relacionadas aos livros. Mantém uma lista de livros e oferece métodos para adicionar e listar livros disponíveis.

### `EmprestimoController`
Gerencia os empréstimos de livros, incluindo a realização de novos empréstimos, listagem de empréstimos ativos e busca de empréstimos por usuário.

### `LivroView`
Responsável por exibir informações detalhadas sobre os livros, como título, autor e ano de publicação.

### `Main`
Classe principal que implementa a interface de linha de comando para o usuário, permitindo cadastrar livros e usuários, realizar empréstimos e listar informações. Também carrega dados iniciais de exemplo no sistema.

## Como Executar

1. Certifique-se de ter o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) instalado.
2. Compile o projeto:
   ```bash
   javac src/main/java/com/SGL/**/*.java
