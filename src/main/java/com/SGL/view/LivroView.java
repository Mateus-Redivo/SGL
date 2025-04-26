package main.java.com.SGL.view;

import main.java.com.SGL.model.Livro;

public class LivroView {
    public void exibirLivro(Livro livro) {
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
    }
}
