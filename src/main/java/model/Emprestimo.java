package model;

import config.DatabaseConfig;
import java.sql.*;
import java.util.Date;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void salvar() {
        String sql = "INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, this.livro.getId());
            pstmt.setInt(2, this.usuario.getIdUsuario());
            pstmt.setString(3, this.dataEmprestimo.toString());
            pstmt.setString(4, this.dataDevolucao.toString());
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Emprestimo buscarPorId(int id) {
        String sql = "SELECT e.*, l.titulo, l.autor, l.ano_publicacao, u.nome " +
                    "FROM emprestimos e " +
                    "JOIN livros l ON e.livro_id = l.id " +
                    "JOIN usuarios u ON e.usuario_id = u.id " +
                    "WHERE e.id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Livro livro = new Livro(
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("ano_publicacao")
                );
                Usuario usuario = new Usuario(
                    rs.getString("nome"),
                    rs.getInt("usuario_id")
                );
                return new Emprestimo(
                    livro,
                    usuario,
                    rs.getDate("data_emprestimo"),
                    rs.getDate("data_devolucao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
