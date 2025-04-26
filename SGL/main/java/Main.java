import model.Livro;
import model.Usuario;
import controller.UsuarioController;
import controller.EmprestimoController;
import controller.LivroController;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando controladores
        UsuarioController usuarioController = new UsuarioController();
        EmprestimoController emprestimoController = new EmprestimoController();

        // Criando usuários
        Usuario usuario1 = new Usuario("João Silva", 1);
        Usuario usuario2 = new Usuario("Maria Oliveira", 2);

        usuarioController.adicionarUsuario(usuario1);
        usuarioController.adicionarUsuario(usuario2);

        // Criando livros
        Livro livro1 = new Livro("Clean Code", "Robert C. Martin", 2008);
        Livro livro2 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);

        // Criando controlador de livros e salvando os livros
        LivroController livroController = new LivroController();
        livroController.adicionarLivro(livro1);
        livroController.adicionarLivro(livro2);
        
        livroController.salvarLivros();

        // Listando livros
        System.out.println("Lista de Livros:");
        List<Livro> livros = livroController.listarLivros();
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
        }

        // Realizando empréstimos
        emprestimoController.realizarEmprestimo(livro1, usuario1, new Date(), new Date());
        emprestimoController.realizarEmprestimo(livro2, usuario2, new Date(), new Date());

        // Listando usuários e empréstimos
        usuarioController.listarUsuarios();
        emprestimoController.listarEmprestimos();
    }
}
