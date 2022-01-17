package usuarios;

public class UsuarioMaster extends Usuario {
    private String senha;
    public UsuarioMaster(String nome, String endereco, String dataNascimento) {
        super(nome, endereco, dataNascimento);
    }
}
