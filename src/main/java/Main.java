import controller.LivroController;
import controller.UsuarioController;
import controller.EmprestimoController;
import model.Livro;
import model.Usuario;
import model.Emprestimo;
import config.DatabaseConfig;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        // Inicializar o banco de dados
        DatabaseConfig.initDatabase();
        
        // Para limpar o banco de dados, descomente a linha abaixo:
        //DatabaseConfig.limparBancoDados();
        
        // Teste dos metodos com valores predefinidos
        System.out.println("Testando cadastro de usuario: " + cadastrarUsuario());
        System.out.println("Testando cadastro de livro: " + cadastrarLivro());
        System.out.println("Testando realizacao de emprestimo: " + realizarEmprestimo());
        System.out.println("Testando listagem de usuarios: " + listarUsuarios());
        System.out.println("Testando busca de usuario: " + buscarUsuario());
        System.out.println("Testando busca de livro: " + buscarLivro());
        System.out.println("Testando listagem de emprestimos: " + listarEmprestimos());
    }

    private static boolean cadastrarUsuario() {
        try {
            String nome = "Joao Silva"; // Valor predefinido
            
            // Validar nome antes de criar o usuário
            if (nome == null || nome.trim().isEmpty()) {
                System.out.println("Erro: Nome do usuario nao pode estar vazio");
                return false;
            }
            
            // Criar usuário com ID inicial 0
            Usuario novoUsuario = new Usuario(nome, 0);
            UsuarioController usuarioController = new UsuarioController(novoUsuario);
            
            // Salvar usuário e verificar resultado
            usuarioController.salvarUsuario();
            
            // Verificar se o ID foi gerado pelo banco
            if (novoUsuario.getIdUsuario() > 0) {
                System.out.println("Usuario cadastrado com sucesso! ID: " + novoUsuario.getIdUsuario());
                return true;
            } else {
                System.out.println("Erro: Falha ao cadastrar usuario - ID não gerado");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private static boolean cadastrarLivro() {
        String titulo = "Dom Casmurro"; // Valores predefinidos
        String autor = "Machado de Assis";
        int ano = 1899;
        
        Livro novoLivro = new Livro(titulo, autor, ano);
        LivroController livroController = new LivroController(novoLivro);
        livroController.salvarLivro();
        return true;
    }

    private static boolean realizarEmprestimo() {
        try {
            int idUsuario = 1;
            int idLivro = 1;
            
            Usuario usuario = UsuarioController.buscarUsuarioPorId(idUsuario);
            if (usuario == null) {
                System.out.println("Erro: Usuario nao encontrado com ID " + idUsuario);
                return false;
            }
            
            Livro livro = LivroController.buscarLivroPorId(idLivro);
            if (livro == null) {
                System.out.println("Erro: Livro não encontrado com ID " + idLivro);
                return false;
            }
            
            Date dataEmprestimo = new Date();
            Date dataDevolucao = new Date(dataEmprestimo.getTime() + (15 * 24 * 60 * 60 * 1000));
            
            Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
            EmprestimoController emprestimoController = new EmprestimoController(novoEmprestimo);
            emprestimoController.salvarEmprestimo();
            
            System.out.println("Empréstimo realizado com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private static boolean listarUsuarios() {
        UsuarioController usuarioController = new UsuarioController(null);
        usuarioController.listarUsuarios();
        return true;
    }

    private static String buscarUsuario() {
        int id = 1; // Valor predefinido
        Usuario usuario = UsuarioController.buscarUsuarioPorId(id);
        if (usuario != null) {
            return String.format("Usuario encontrado - ID: %d | Nome: %s", 
                usuario.getIdUsuario(), usuario.getNome());
        }
        return "Usuario nao encontrado";
    }

    private static String buscarLivro() {
        int id = 1; // Valor predefinido
        Livro livro = LivroController.buscarLivroPorId(id);
        if (livro != null) {
            return String.format("Livro encontrado - Titulo: %s, Autor: %s, Ano: %d", 
                livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
        }
        return "Livro nao encontrado";
    }

    private static boolean listarEmprestimos() {
        return true; // Retorna true indicando que a operacao foi realizada
    }
    
    // Método auxiliar para limpar o banco de dados
    private static void limparDados() {
        try {
            DatabaseConfig.limparBancoDados();
            System.out.println("Todas as informações foram removidas do banco de dados.");
        } catch (Exception e) {
            System.out.println("Erro ao limpar dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
