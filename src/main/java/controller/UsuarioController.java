package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.DatabaseConfig;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuario;

    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para adicionar um novo usuário
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario " + usuario.getNome() + " cadastrado com sucesso!");
    }

    // Método para buscar um usuário pelo ID
    public Usuario buscarUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        System.out.println("Usuario nao encontrado.");
        return null;
    }

    public static Usuario buscarUsuarioPorId(int id) {
        return Usuario.buscarPorId(id);
    }

    // Método para listar todos os usuários cadastrados
    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            boolean encontrouUsuarios = false;
            System.out.println("\nLista de Usuarios:");
            while (rs.next()) {
                encontrouUsuarios = true;
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                System.out.println("ID: " + id + " | Nome: " + nome);
            }
            
            if (!encontrouUsuarios) {
                System.out.println("Nenhum usuario cadastrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void salvarUsuario() {
        if (validarUsuario()) {
            usuario.salvar();
        }
    }

    private boolean validarUsuario() {
        return usuario.getNome() != null && !usuario.getNome().trim().isEmpty();
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
