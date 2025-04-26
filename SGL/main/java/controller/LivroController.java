package controller;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroController {
    private List<Livro> livros;

    public LivroController() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void salvarLivros() {
        // Implementar lógica para salvar todos os livros
        for (Livro livro : livros) {
            System.out.println("Salvando livro: " + livro.getTitulo());
        }
    }

    public List<Livro> listarLivros() {
        return livros;
    }
}
