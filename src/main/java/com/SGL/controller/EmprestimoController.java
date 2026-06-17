package main.java.com.sgl.controller;

import main.java.com.sgl.model.Emprestimo;
import main.java.com.sgl.model.Usuario;
import main.java.com.sgl.model.Livro;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class EmprestimoController {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    // POST - Realizar emprestimo
    public void realizarEmprestimo(Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucao) {
        Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
        emprestimos.add(novoEmprestimo);
        System.out.println("Emprestimo realizado");
    }

    // GET - Lista todos os emprestimos
    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nao temos emprestimos realizados");
            return;
        }
        System.out.println("Lista de emprestimos");
        for (Emprestimo e : emprestimos) {
            System.out.println("Livro: " + e.getLivro().getTitulo() +
                    " | Usuario: " + e.getUsuario().getNome() +
                    " | Data de devolucao: " + e.getDataDevolucao());
        }
    }

    // GET - Busca emprestimo por usuario

    public List<Emprestimo> buscaEmprestimosPorUsuario(int idUsuario) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getIdUsuario() == idUsuario) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }
}
