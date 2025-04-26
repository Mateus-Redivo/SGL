package main.java.com.SGL.app;

import main.java.com.SGL.controller.EmprestimoController;
import main.java.com.SGL.controller.UsuarioController;
import main.java.com.SGL.controller.LivroController;
import main.java.com.SGL.model.Livro;
import main.java.com.SGL.model.Usuario;
import main.java.com.SGL.model.Emprestimo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UsuarioController usuarioController = new UsuarioController();
    private static EmprestimoController emprestimoController = new EmprestimoController();
    private static LivroController livroController = new LivroController();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        carregarDadosIniciais();
        
        boolean sair = false;
        
        while (!sair) {
            exibirMenu();
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> cadastrarUsuario();
                case 3 -> realizarEmprestimo();
                case 4 -> listarLivros();
                case 5 -> listarUsuarios();
                case 6 -> listarEmprestimos();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                    sair = true;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
            
            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine();
        }
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n===== SISTEMA DE GESTÃO DE LIVROS =====");
        System.out.println("1. Cadastrar novo livro");
        System.out.println("2. Cadastrar novo usuário");
        System.out.println("3. Realizar empréstimo");
        System.out.println("4. Listar livros");
        System.out.println("5. Listar usuários");
        System.out.println("6. Listar empréstimos");
        System.out.println("7. Salvar dados");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void cadastrarLivro() {
        System.out.println("\n=== CADASTRO DE LIVRO ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de publicação: ");
        int ano = Integer.parseInt(scanner.nextLine());
        
        Livro livro = new Livro(titulo, autor, ano);
        livroController.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }
    
    private static void cadastrarUsuario() {
        System.out.println("\n=== CADASTRO DE USUÁRIO ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Usuario usuario = new Usuario(nome, id);
        usuarioController.adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
    
    private static void realizarEmprestimo() {
        System.out.println("\n=== REALIZAR EMPRÉSTIMO ===");
        
        // Listar livros disponíveis
        List<Livro> livros = livroController.listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados!");
            return;
        }
        
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println((i+1) + ". " + livros.get(i).getTitulo() + " - " + livros.get(i).getAutor());
        }
        System.out.print("Selecione o número do livro: ");
        int livroIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (livroIndex < 0 || livroIndex >= livros.size()) {
            System.out.println("Livro inválido!");
            return;
        }
        
        // Listar usuários
        List<Usuario> usuarios = usuarioController.obterUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Não há usuários cadastrados!");
            return;
        }
        
        System.out.println("Usuários cadastrados:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i+1) + ". " + usuarios.get(i).getNome() + " (ID: " + usuarios.get(i).getIdUsuario() + ")");
        }
        System.out.print("Selecione o número do usuário: ");
        int usuarioIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (usuarioIndex < 0 || usuarioIndex >= usuarios.size()) {
            System.out.println("Usuário inválido!");
            return;
        }
        
        try {
            System.out.print("Data de empréstimo (dd/MM/yyyy): ");
            Date dataEmprestimo = dateFormat.parse(scanner.nextLine());
            
            System.out.print("Data de devolução (dd/MM/yyyy): ");
            Date dataDevolucao = dateFormat.parse(scanner.nextLine());
            
            emprestimoController.realizarEmprestimo(
                livros.get(livroIndex), 
                usuarios.get(usuarioIndex), 
                dataEmprestimo, 
                dataDevolucao
            );
            
        } catch (ParseException e) {
            System.out.println("Formato de data inválido! Use dd/MM/yyyy");
        }
    }
    
    private static void listarLivros() {
        System.out.println("\n=== LISTA DE LIVROS ===");
        List<Livro> livros = livroController.listarLivros();
        
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return;
        }
        
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo() + 
                               ", Autor: " + livro.getAutor() + 
                               ", Ano: " + livro.getAnoPublicacao());
        }
    }
    
    private static void listarUsuarios() {
        System.out.println("\n=== LISTA DE USUÁRIOS ===");
        usuarioController.listarUsuarios();
    }
    
    private static void listarEmprestimos() {
        System.out.println("\n=== LISTA DE EMPRÉSTIMOS ===");
        emprestimoController.listarEmprestimos();
    }
    
    private static void carregarDadosIniciais() {
        // Você pode carregar dados iniciais aqui se necessário
        // Exemplo:
        Usuario usuario1 = new Usuario("João Silva", 1);
        Usuario usuario2 = new Usuario("Maria Oliveira", 2);
        
        usuarioController.adicionarUsuario(usuario1);
        usuarioController.adicionarUsuario(usuario2);
        
        Livro livro1 = new Livro("Clean Code", "Robert C. Martin", 2008);
        Livro livro2 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        
        livroController.adicionarLivro(livro1);
        livroController.adicionarLivro(livro2);
    }
}
