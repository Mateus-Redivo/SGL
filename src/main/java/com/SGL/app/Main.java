package main.java.com.sgl.app;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import main.java.com.sgl.controller.EmprestimoController;
import main.java.com.sgl.controller.LivroController;
import main.java.com.sgl.controller.UsuarioController;
import main.java.com.sgl.model.Livro;
import main.java.com.sgl.model.Usuario;

public class Main {

    private static UsuarioController usuarioController = new UsuarioController();
    private static LivroController livroController = new LivroController();
    private static EmprestimoController emprestimoController = new EmprestimoController();

    private static Scanner scanner = new Scanner(System.in);

    private static SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

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
                case 4 -> listaLivros();
                case 5 -> listaUsuarios();
                case 6 -> litasEmprestimos();
                case 0 -> {
                    System.out.println("Saindo");
                    sair = true;
                }
                default -> System.out.println("Opção invalida");
            }
            scanner.close();
        }
    }

    private static Object litasEmprestimos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'litasEmprestimos'");
    }

    private static Object listaUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listaUsuarios'");
    }

    private static Object listaLivros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listaLivros'");
    }

    private static Object realizarEmprestimo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'realizarEmprestimo'");
    }

    private static Object cadastrarLivro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarLivro'");
    }

    private static void cadastrarUsuario() {
       System.out.println("Cadastrar usuario");
       System.out.print("Digite o nome: ");
       String nome = scanner.nextLine();
       System.out.print("ID: ");
       int id = Integer.parseInt(scanner.nextLine());

       Usuario usuario = new Usuario(nome, id);
       usuarioController.adicionarUsuario(usuario);
       System.out.println("Usuario cadastrado");
    }


   

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void exibirMenu() {
        System.out.println("Sistema de gestao de emprestimos");
        System.out.println("1. Cadastrar novo livro");
        System.out.println("2. Cadastrar novo usuario");
        System.out.println("3. Realizar emprestimo");
        System.out.println("4. Listar livro");
        System.out.println("5. Listar usuarios");
        System.out.println("6. Listar emprestimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção:");
    }

    private static void carregarDadosIniciais() {
        // Criacao dos dados iniciais
        Usuario usuario1 = new Usuario("Joao", 1);
        Usuario usuario2 = new Usuario("Maria", 2);

        usuarioController.adicionarUsuario(usuario1);
        usuarioController.adicionarUsuario(usuario2);

        Livro livro1 = new Livro("Titulo", "Autor", 2020);
        Livro livro2 = new Livro("Titulo2", "Autor2", 2021);

        livroController.adicionarLivro(livro1);
        livroController.adicionarLivro(livro2);
    }
}