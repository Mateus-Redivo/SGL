# Sistema de Gerenciamento de Livros (SGL)

Este é um projeto simples em Java para gerenciar livros, usuários e empréstimos em uma biblioteca. Ele foi desenvolvido com o objetivo de demonstrar conceitos básicos de programação orientada a objetos, como encapsulamento, herança e composição, além de boas práticas de organização de código.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

### Descrição dos Diretórios

- **controller/**: Contém as classes responsáveis pela lógica de controle, como gerenciar empréstimos, usuários e livros.
- **model/**: Contém as classes que representam os modelos de dados, como `Livro`, `Usuario` e `Emprestimo`.
- **view/**: Contém as classes responsáveis pela exibição de informações, como a `LivroView`.
- **Main.java**: Classe principal que inicializa o sistema e demonstra o funcionamento das funcionalidades.

## Funcionalidades

### Gerenciamento de Usuários
- Adicionar novos usuários.
- Buscar usuários pelo ID.
- Listar todos os usuários cadastrados.

### Gerenciamento de Livros
- Criar e salvar informações sobre livros.
- Exibir detalhes de um livro.

### Gerenciamento de Empréstimos
- Realizar empréstimos de livros para usuários.
- Buscar empréstimos por usuário.
- Listar todos os empréstimos ativos.

## Classes Principais

### `UsuarioController`
Gerencia as operações relacionadas aos usuários, como cadastro, busca e listagem.

### `LivroController`
Gerencia as operações relacionadas aos livros, como salvar e manipular informações de livros.

### `EmprestimoController`
Gerencia os empréstimos de livros, incluindo a criação de novos empréstimos e a listagem de empréstimos ativos.

### `LivroView`
Responsável por exibir informações sobre os livros.

### `Main`
Classe principal que demonstra o uso das funcionalidades do sistema.

## Como Executar

1. Certifique-se de ter o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) instalado.
2. Compile o projeto:
   ```bash
   javac main/java/**/*.java
