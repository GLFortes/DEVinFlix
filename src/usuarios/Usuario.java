package usuarios;

import filmes.Filme;

import java.util.ArrayList;

public class Usuario {
    protected String nome;
    protected String endereco;
    protected String dataNascimento;
    protected ArrayList<Filme> filmesRecomendados = new ArrayList<>();

    public Usuario( String nome, String endereco, String dataNascimento ) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.filmesRecomendados = new ArrayList<>();
    }

    public Usuario(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(){}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Filme> getFilmesRecomendados() {
        return filmesRecomendados;
    }

    public void setFilmesRecomendados(ArrayList<Filme> filmesRecomendados) {
        this.filmesRecomendados = filmesRecomendados;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }

    public void recomendarFilme(Filme filme, String motivo) {
        System.out.println(this.nome + " recomendou o filme " + filme.getTitulo() + " porque " + motivo);
    }
}
