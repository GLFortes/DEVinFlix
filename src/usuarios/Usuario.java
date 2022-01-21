package usuarios;

import filmes.Filme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;


public class Usuario {
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String senha;
    private HashSet<String> filmesRecomendados = new HashSet<>();
    private HashSet<Filme> filmesCurtidos = new HashSet<>();
    private HashSet<Filme> filmesDescurtidos = new HashSet<>();


    public Usuario(String nome, String endereco, String dataNascimento, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public Usuario(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(){}

    public HashSet<Filme> getFilmesCurtidos() {
        return filmesCurtidos;
    }

    public void setFilmesCurtidos(HashSet<Filme> filmesCurtidos) {
        this.filmesCurtidos = filmesCurtidos;
    }

    public HashSet<Filme> getFilmesDescurtidos() {
        return filmesDescurtidos;
    }

    public void setFilmesDescurtidos(HashSet<Filme> filmesDescurtidos) {
        this.filmesDescurtidos = filmesDescurtidos;
    }

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

    public HashSet<String> getFilmesRecomendados() {
        return filmesRecomendados;
    }

    public void setFilmesRecomendados(HashSet<String> filmesRecomendados) {
        this.filmesRecomendados = filmesRecomendados;
    }
    public void addFilmes(String filme) {
        this.filmesRecomendados.add(filme);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        System.out.println(this.nome + " recomendou o filme " + filme.getTitulo() + " \nMotivo: " + motivo);
        filmesRecomendados.add(filme.getTitulo());
    }
    public void curtirFilme(Filme filme) {
        System.out.println(this.nome + " curtiu o filme " + filme.getTitulo());
        filmesCurtidos.add(filme);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(endereco, usuario.endereco) && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(filmesRecomendados, usuario.filmesRecomendados) && Objects.equals(filmesCurtidos, usuario.filmesCurtidos) && Objects.equals(filmesDescurtidos, usuario.filmesDescurtidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco, dataNascimento, filmesRecomendados, filmesCurtidos, filmesDescurtidos);
    }
}
