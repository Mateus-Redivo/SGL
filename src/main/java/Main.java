import controller.LivroController;
import controller.UsuarioController;
import controller.EmprestimoController;
import model.Livro;
import model.Usuario;
import model.Emprestimo;
import config.DatabaseConfig;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar o banco de dados
        DatabaseConfig.initDatabase();
        
        while (true) {
            exibirMenu();
            try {

                int opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1:
                        cadastrarUsuario();
                        break;
                    case 2:
                        cadastrarLivro();
                        break;
                    case 3:
                        realizarEmprestimo();
                        break;
                    case 4:
                        listarUsuarios();
                        break;
                    case 5:
                        buscarUsuario();
                        break;
                    case 6:
                        buscarLivro();
                        break;
                    case 7:
                        listarEmprestimos();
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA ===");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Cadastrar Livro");
        System.out.println("3. Realizar Empréstimo");
        System.out.println("4. Listar Usuários");
        System.out.println("5. Buscar Usuário");
        System.out.println("6. Buscar Livro");
        System.out.println("7. Listar Empréstimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarUsuario() {
        System.out.println("\n=== CADASTRO DE USUÁRIO ===");
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();
        
        Usuario novoUsuario = new Usuario(nome, 0);
        UsuarioController usuarioController = new UsuarioController(novoUsuario);
        usuarioController.salvarUsuario();
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void cadastrarLivro() {
        System.out.println("\n=== CADASTRO DE LIVRO ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de publicação: ");
        int ano = scanner.nextInt();
        
        Livro novoLivro = new Livro(titulo, autor, ano);
        LivroController livroController = new LivroController(novoLivro);
        livroController.salvarLivro();
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void realizarEmprestimo() {
        try {
            System.out.println("\n=== REALIZAR EMPRÉSTIMO ===");
            System.out.print("ID do usuário: ");
            int idUsuario = scanner.nextInt();
            System.out.print("ID do livro: ");
            int idLivro = scanner.nextInt();
            
            Usuario usuario = UsuarioController.buscarUsuarioPorId(idUsuario);
            Livro livro = LivroController.buscarLivroPorId(idLivro);
            
            if (usuario == null || livro == null) {
                System.out.println("Usuário ou livro não encontrado!");
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataEmprestimo = new Date();
            // Define data de devolução para 15 dias após o empréstimo
            Date dataDevolucao = new Date(dataEmprestimo.getTime() + (15 * 24 * 60 * 60 * 1000));
            
            Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
            EmprestimoController emprestimoController = new EmprestimoController(novoEmprestimo);
            emprestimoController.salvarEmprestimo();
            
            System.out.println("Empréstimo realizado com sucesso!");
            System.out.println("Data de devolução: " + sdf.format(dataDevolucao));
        } catch (Exception e) {
            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
        }
    }

    private static void listarUsuarios() {
        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");
        UsuarioController usuarioController = new UsuarioController(null);
        usuarioController.listarUsuarios();
    }

    private static void buscarUsuario() {
        System.out.println("\n=== BUSCAR USUÁRIO ===");
        System.out.print("Digite o ID do usuário: ");
        int id = scanner.nextInt();
        
        Usuario usuario = UsuarioController.buscarUsuarioPorId(id);
        if (usuario != null) {
            System.out.println("Usuário encontrado:");
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nome: " + usuario.getNome());
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private static void buscarLivro() {
        System.out.println("\n=== BUSCAR LIVRO ===");
        System.out.print("Digite o ID do livro: ");
        int id = scanner.nextInt();
        
        Livro livro = LivroController.buscarLivroPorId(id);
        if (livro != null) {
            System.out.println("Livro encontrado:");
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private static void listarEmprestimos() {
        System.out.println("\n=== EMPRÉSTIMOS REALIZADOS ===");
        // Implementar lógica para listar empréstimos do banco
        // Esta funcionalidade precisa ser implementada na classe EmprestimoController
        System.out.println("Funcionalidade em desenvolvimento...");
    }
}
