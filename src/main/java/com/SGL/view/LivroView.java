package main.java.com.sgl.view;

import main.java.com.sgl.model.Livro;

public class LivroView {

    public void exibirLivro(Livro livro) {
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
    }
}
