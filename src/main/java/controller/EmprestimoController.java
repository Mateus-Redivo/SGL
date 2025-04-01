package controller;

import model.Emprestimo;
import model.Livro;
import model.Usuario;
import java.util.Date;

public class EmprestimoController {
    private Emprestimo emprestimo;

    public EmprestimoController(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void salvarEmprestimo() {
        if (validarEmprestimo()) {
            emprestimo.salvar();
        }
    }

    public static Emprestimo buscarEmprestimoPorId(int id) {
        return Emprestimo.buscarPorId(id);
    }

    private boolean validarEmprestimo() {
        return emprestimo.getLivro() != null &&
               emprestimo.getUsuario() != null &&
               emprestimo.getDataEmprestimo() != null &&
               emprestimo.getDataDevolucao() != null &&
               emprestimo.getDataDevolucao().after(emprestimo.getDataEmprestimo());
    }

    // Getters e Setters
    public Livro getLivro() {
        return emprestimo.getLivro();
    }

    public void setLivro(Livro livro) {
        emprestimo.setLivro(livro);
    }

    public Usuario getUsuario() {
        return emprestimo.getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        emprestimo.setUsuario(usuario);
    }

    public Date getDataEmprestimo() {
        return emprestimo.getDataEmprestimo();
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        emprestimo.setDataEmprestimo(dataEmprestimo);
    }

    public Date getDataDevolucao() {
        return emprestimo.getDataDevolucao();
    }

    public void setDataDevolucao(Date dataDevolucao) {
        emprestimo.setDataDevolucao(dataDevolucao);
    }
}
