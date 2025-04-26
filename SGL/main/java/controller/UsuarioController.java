package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

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
    
    // Método para obter a lista de usuários
    public List<Usuario> obterUsuarios() {
        return usuarios;
    }
}
