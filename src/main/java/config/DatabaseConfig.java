package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String DB_URL = "jdbc:sqlite:biblioteca.db";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
    
    public static void initDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            // Criar tabela de usuários
            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (" +
                        "id INTEGER PRIMARY KEY," +
                        "nome TEXT NOT NULL)");
            
            // Criar tabela de livros
            stmt.execute("CREATE TABLE IF NOT EXISTS livros (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "titulo TEXT NOT NULL," +
                        "autor TEXT NOT NULL," +
                        "ano_publicacao INTEGER)");
            
            // Criar tabela de empréstimos
            stmt.execute("CREATE TABLE IF NOT EXISTS emprestimos (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "livro_id INTEGER," +
                        "usuario_id INTEGER," +
                        "data_emprestimo TEXT," +
                        "data_devolucao TEXT," +
                        "FOREIGN KEY(livro_id) REFERENCES livros(id)," +
                        "FOREIGN KEY(usuario_id) REFERENCES usuarios(id))");
                        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}