package main.java.com.sgl.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.com.sgl.model.Usuario;

public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    // ENDPOINT POST - Adicionar usuario

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario: " + usuario.getNome() + " foi adicionado");
    }

    // ENDPOINT GET (BY ID) - Busca usuario por ID

    public Usuario buscaUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (idUsuario == usuario.getIdUsuario()) {
                return usuario;
            }
        }
        System.out.println("Usuario nao cadastrado");
        return null;
    }

    // ENDPOINT GET - Busca todos os usuario

    public void listarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado");
            return;
        }
        System.out.println("Lista de usuarios :");
        for (Usuario usuario : usuarios) {
            System.out.println("ID " + usuario.getIdUsuario()
                    + "| Nome: " + usuario.getNome());
        }
    }

    //Metodo para obter a lista de usuarios
    public List<Usuario> obterUsuarios(){
        return usuarios;
    }
}
