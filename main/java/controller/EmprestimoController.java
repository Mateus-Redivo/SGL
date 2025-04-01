package controller;

import model.Emprestimo;
import model.Livro;
import model.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmprestimoController {
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // Método para realizar um empréstimo
    public void realizarEmprestimo(Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucao) {
        Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
        emprestimos.add(novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso!");
    }

    // Método para buscar empréstimos de um usuário
    public List<Emprestimo> buscarEmprestimosPorUsuario(int idUsuario) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getIdUsuario() == idUsuario) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }

    // Método para listar todos os empréstimos ativos
    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        System.out.println("Lista de Empréstimos:");
        for (Emprestimo e : emprestimos) {
            System.out.println("Livro: " + e.getLivro().getTitulo() +
                    " | Usuário: " + e.getUsuario().getNome() +
                    " | Data de Devolução: " + e.getDataDevolucao());
        }
    }
}
