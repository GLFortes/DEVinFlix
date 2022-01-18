import filmes.Filme;
import usuarios.Usuario;
import usuarios.UsuarioAgregado;
import usuarios.UsuarioMaster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static filmes.Genero.*;

public class Plataforma {
//    public void curtirFilme(String filme, boolean curtir){
//        if (curtir){
//            filme.setCurtidas(filme.getCurtidas() + 1);
//        }else{
//            filme.setDescurtidas(filme.getDescurtidas() + 1);
//        }
//    }

    public void recomendarFilme(Filme filme, Usuario usuario, String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por quê você recomendaria este filme?");
        String motivo = scanner.nextLine();
    }

    public void recomendarFilme(Filme filme, Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por quê você recomendaria este filme?");
        String motivo = scanner.nextLine();
        usuario.recomendarFilme(filme, motivo);
    }

    public void Login(String username){
        System.out.println("Usuário logado com sucesso");
    }
    public void ImprimeOpcoes(){
        System.out.println("1 - Curtir Filme");
        System.out.println("2 - Recomendar Filme");
        System.out.println("3 - Sair");
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma devinflix = new Plataforma();
        ArrayList<String> sugestoes = new ArrayList<String>();
        HashSet<String>filmesSugeridos = new HashSet<String>();
        HashSet<Filme> catalogoFilmes = new HashSet<Filme>();
        catalogoFilmes.add(new Filme("Avengers Ultimato", "Os caras tretam com o Thanos", ACAO));
        catalogoFilmes.add(new Filme("Miranha Sem Volta pra Casa", "Peter Parker estraga a linha do tempo", ACAO));
        catalogoFilmes.add(new Filme("O rei Leão", "Leão e seus amigos se preparam para a guerra pelo terreno da família", ANIMACAO));
        catalogoFilmes.add(new Filme("A lagoa azul kkk", "Não lembro, faz tempo que vi", DRAMA));
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new UsuarioMaster("Guilherme", "Alvorada", "24/08/1995"));
        Usuario master = new UsuarioMaster("Guilherme", "Alvorada", "24/08/1995");
        usuarios.add(new UsuarioAgregado("Julia", "Alvorada", "20/03/2000"));
        usuarios.add(new UsuarioAgregado("Juvencio", "Alvorada", "09/03/1969"));
        System.out.println(usuarios.toString());
        System.out.println("\nFilmes recomendados: " + usuarios.get(0).getFilmesRecomendados().toString());

        while (true) {
            devinflix.ImprimeOpcoes();
            System.out.println("Escolha uma opção:");
            String opcao = scanner.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("Escolha um filme do catálogo para curtir ou descurtir:");
                    //mostrar apenas os titulos
                    for (Filme filme : catalogoFilmes) {
                        System.out.println(filme.getTitulo());
                    }
                    String nomeFilme = scanner.nextLine();
                    for (Filme filme : catalogoFilmes) {
                        if (filme.getTitulo().equalsIgnoreCase(nomeFilme)) {
                            System.out.println("Curtir ou descurtir?");
                            String curtir = scanner.nextLine();
                            if (curtir.equalsIgnoreCase("curtir")){
                                for(Filme filme2 : catalogoFilmes){
                                    if(filme2.getTitulo().equalsIgnoreCase(nomeFilme)){
                                        filme.setCurtidas(filme.getCurtidas() + 1);
                                    }else if(filme2.getTitulo().equalsIgnoreCase(nomeFilme)){
                                        filme.setDescurtidas(filme.getDescurtidas() + 1);
                            break;
                        }
                            }
                        }
                    }else{
                            System.out.println("Filme não encontrado");
                            break;

                        }
                    }

                    break;
                case "2":
                    System.out.println("--RECOMENDAR FILME--");
                    System.out.println("Escolha um usuário para recomendar o filme:");
                    for (Usuario usuario : usuarios){
                        System.out.println(usuario.getNome());
                    }
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Usuario " + nomeUsuario + " escolhido");
                    System.out.println("Escolha um filme para recomendar:");
                    for (Filme filme : catalogoFilmes) {
                        System.out.println(filme.getTitulo());
                    }
                    String filmeRecomendado = scanner.nextLine();
                    if (filmesSugeridos.contains(filmeRecomendado)){
                        System.out.println("Filme já foi sugerido");
                    }
                    else {
                        System.out.println("Filme escolhido: ");
                    }
                    System.out.println("Filme " + filmeRecomendado + " escolhido");
                    break;
                case "3":
                    System.out.println("-- SUGESTÃO DE FILME --");
                    System.out.println("Qual filme gostaria de sugerir?");
                    String filmeSugerido = scanner.nextLine();
                    for (Filme filme : catalogoFilmes) {
                        System.out.println(filme.getTitulo());
                        if (filmesSugeridos.contains(filme.getTitulo())){
                            System.out.println("Filme já foi sugerido");
                        }else{
                            System.out.println("Filme " + filmeSugerido + " sugerido.");
                            filmesSugeridos.add(filmeSugerido);
                            //teste se está sendo sugerido
                            System.out.println(filmesSugeridos);
                        }
                        break;
                    }
            }
        }
    }
}
