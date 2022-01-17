package filmes;

import java.util.Objects;

public class Filme {
    private String titulo;
    private String sinopse;
    private Genero genero;
    private int curtidas;
    private int descurtidas;

    public Filme(String titulo, String sinopse, Genero genero) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        curtidas = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public int getDescurtidas() {
        return descurtidas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public void setDescurtidas(int descurtidas) {
        this.descurtidas = descurtidas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(titulo, filme.titulo) && Objects.equals(sinopse, filme.sinopse) && genero == filme.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, sinopse, genero);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", genero=" + genero +
                ", curtidas=" + curtidas +
                ", descurtidas=" + descurtidas +
                '}';
    }
}
