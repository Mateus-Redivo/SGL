package main.java.com.SGL.controller;

import main.java.com.SGL.model.Livro;
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

    
    public List<Livro> listarLivros() {
        return livros;
    }
}
