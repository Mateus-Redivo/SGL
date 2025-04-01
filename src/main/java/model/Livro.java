package model;

import config.DatabaseConfig;
import java.sql.*;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void salvar() {
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, this.titulo);
            pstmt.setString(2, this.autor);
            pstmt.setInt(3, this.anoPublicacao);
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Livro buscarPorId(int id) {
        String sql = "SELECT * FROM livros WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Livro(
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("ano_publicacao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
