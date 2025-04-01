package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuario;

    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para adicionar um novo usuário
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso!");
    }

    // Método para buscar um usuário pelo ID
    public Usuario buscarUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }

    public static Usuario buscarUsuarioPorId(int id) {
        return Usuario.buscarPorId(id);
    }

    // Método para listar todos os usuários cadastrados
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("Lista de Usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getIdUsuario() + " | Nome: " + usuario.getNome());
        }
    }

    public void salvarUsuario() {
        if (validarUsuario()) {
            usuario.salvar();
        }
    }

    private boolean validarUsuario() {
        return usuario.getNome() != null && 
               !usuario.getNome().trim().isEmpty() && 
               usuario.getIdUsuario() > 0;
    }

    // Getters e Setters
    public String getNome() {
        return usuario.getNome();
    }

    public void setNome(String nome) {
        usuario.setNome(nome);
    }

    public int getIdUsuario() {
        return usuario.getIdUsuario();
    }

    public void setIdUsuario(int idUsuario) {
        usuario.setIdUsuario(idUsuario);
    }
}
