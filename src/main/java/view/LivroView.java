package view;

import model.Livro;

public class LivroView {
    public void exibirLivro(Livro livro) {
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
    }
}
