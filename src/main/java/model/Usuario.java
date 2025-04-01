package model;

import config.DatabaseConfig;
import java.sql.*;

public class Usuario {
    private int idUsuario;
    private String nome;

    public Usuario(String nome, int idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void salvar() {
        String sql = "INSERT INTO usuarios (nome) VALUES (?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, this.nome);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        this.idUsuario = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                    rs.getString("nome"),
                    rs.getInt("id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
