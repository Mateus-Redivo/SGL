package controller;

import model.Livro;

public class LivroController {
    private Livro livro;

    public LivroController(Livro livro) {
        this.livro = livro;
    }

    public void salvarLivro() {
        if (validarLivro()) {
            livro.salvar();
        }
    }

    public static Livro buscarLivroPorId(int id) {
        return Livro.buscarPorId(id);
    }

    private boolean validarLivro() {
        return livro.getTitulo() != null && !livro.getTitulo().trim().isEmpty() &&
               livro.getAutor() != null && !livro.getAutor().trim().isEmpty() &&
               livro.getAnoPublicacao() > 0;
    }

    // Getters and setters for livro attributes
    public String getTitulo() {
        return livro.getTitulo();
    }

    public void setTitulo(String titulo) {
        livro.setTitulo(titulo);
    }

    public String getAutor() {
        return livro.getAutor();
    }

    public void setAutor(String autor) {
        livro.setAutor(autor);
    }

    public int getAnoPublicacao() {
        return livro.getAnoPublicacao();
    }

    public void setAnoPublicacao(int anoPublicacao) {
        livro.setAnoPublicacao(anoPublicacao);
    }

    public int getId() {
        return livro.getId();
    }
}
