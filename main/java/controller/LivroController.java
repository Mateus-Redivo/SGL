package controller;

import model.Livro;

public class LivroController {
    private Livro livro;

    public LivroController(Livro livro) {
        this.livro = livro;
    }

    public void salvarLivro() {
        // Lógica para salvar o livro no banco de dados ou realizar outra operação
    }
}
