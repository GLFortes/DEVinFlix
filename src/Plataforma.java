import filmes.Filme;
import usuarios.Usuario;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static filmes.Genero.*;

public class Plataforma {
    private Set<Usuario> usuarios = new HashSet<>();
    public Plataforma(){
        usuarios.add(new Usuario("Guilherme", "POA","24/08/1995", "12345"));
        usuarios.add(new Usuario("Julia", "Alvorada", "20/03/2000", "54321"));
        usuarios.add(new Usuario("Juvencio", "Alvorada", "09/03/1969","123456"));
    }
    public void addUser(Usuario usuario){
        usuarios.add(usuario);
    }
    public boolean login(String nome, String senha){
        boolean check = false;
        for (Usuario usuario : usuarios) {
            if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)){
                check = true;
                return true;
            }
            }return false;
        }


    public void ImprimeOpcoes(){
        System.out.println("1 - Curtir Filme");
        System.out.println("2 - Recomendar Filme");
        System.out.println("3 - Sair");
    }



    public static void main(String[] args) {
        while (true) {
        Scanner scanner = new Scanner(System.in);
        Plataforma devinflix = new Plataforma();
        System.out.println("--LOGIN__");
        System.out.println("Digite seu nome de usuário: ");
        String userName = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String userPass = scanner.nextLine();
        devinflix.login(userName, userPass);

        for (Usuario usuariolog : devinflix.usuarios) {
            if (usuariolog.getNome().equalsIgnoreCase(userName) && usuariolog.getSenha().equals(userPass)) {
                System.out.println("Bem vindo " + usuariolog.getNome());
                Usuario usuarioLogado = usuariolog;

            HashSet<String> filmesSugeridos = new HashSet<String>();
            HashSet<Filme> catalogoFilmes = new HashSet<Filme>();
            catalogoFilmes.add(new Filme("Avengers Ultimato", "Os caras tretam com o Thanos", ACAO));
            catalogoFilmes.add(new Filme("Miranha Sem Volta pra Casa", "Peter Parker estraga a linha do tempo", ACAO));
            catalogoFilmes.add(new Filme("O rei Leão", "Leão e seus amigos se preparam para a guerra pelo terreno da família", ANIMACAO));
            catalogoFilmes.add(new Filme("A lagoa azul kkk", "Não lembro, faz tempo que vi", DRAMA));
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>(5);
            ArrayList<HashSet<Filme>> recomendacoe = new ArrayList<HashSet<Filme>>(5);
            usuarios.add(new Usuario("Guilherme", "Alvorada", "24/08/1995", "lolzinhoprasempre"));
            usuarios.add(new Usuario("Julia", "Alvorada", "20/03/2000", "12345"));
            usuarios.add(new Usuario("Juvencio", "Alvorada", "09/03/1969", "12345"));
            System.out.println(usuarios.toString());
            System.out.println("\nFilmes recomendados: " + usuarios.get(0).getFilmesRecomendados().toString());

                devinflix.ImprimeOpcoes();
                System.out.println("Escolha uma opção:");
                String opcao = scanner.nextLine();
                switch (opcao) {
                    //CURTIR OU DESCURTIR FILME
                    case "1":
                        System.out.println("Escolha um filme do catálogo para curtir ou descurtir:");
                        for (Filme filme : catalogoFilmes) {
                            System.out.println(filme.getTitulo());
                        }
                        String nomeFilme = scanner.nextLine();
                        for (Filme filme : catalogoFilmes) {
                            if (filme.getTitulo().equalsIgnoreCase(nomeFilme)) {
                                Filme likedFilme = filme;
                                System.out.println("Curtir ou descurtir?");
                                String curtir = scanner.nextLine();
                                if (curtir.equalsIgnoreCase("curtir")) {
                                    System.out.println("Curtiu!");
                                    likedFilme.setCurtidas(likedFilme.getCurtidas() + 1);
                                    usuarioLogado.curtirFilme(likedFilme);

                            }else {
                                    System.out.println("Descurtiu!");
                                    likedFilme.setCurtidas(likedFilme.getCurtidas() - 1);
                                }
                            }else {
                                System.out.println("Filme não encontrado");
                                break;
                        }}
                        break;
                    //RECOMENDAR FILME
                    case "2":
                        System.out.println("--RECOMENDAR FILME--");
                        System.out.println("Escolha um usuário para recomendar o filme:");
                        for (Usuario usuario : usuarios) {
                            System.out.println(usuario.getNome());
                        }
                        String nomeUsuario = scanner.nextLine();
                        for (Usuario usuario : usuarios) {
                            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                                System.out.println("Escolha um filme do catálogo para recomendar:");
                                for (Filme filme : catalogoFilmes) {
                                    System.out.println(filme.getTitulo());
                                }
                                String filmeRecomendado = scanner.nextLine();
                                System.out.println("Por que você recomendaria esse filme?");
                                String motivo = scanner.nextLine();
                                for (Filme filme2 : catalogoFilmes) {
                                    if (filme2.getTitulo().equalsIgnoreCase(filmeRecomendado)) {
                                        Filme filminho = filme2;
                                        usuario.recomendarFilme(filminho, motivo);
                                        break;
                                    } else {
                                        System.out.println("Filme não encontrado");
                                        break;
                                    }


                                }

                            }
                        }
                        break;

                    //SUGERIR FILME À PLATAFORMA
                    case "3":
                        System.out.println("-- SUGESTÃO DE FILME --");
                        System.out.println("Qual filme gostaria de sugerir?");
                        String filmeSugerido = scanner.nextLine();
                        for (Filme filme : catalogoFilmes) {
                            System.out.println(filme.getTitulo());
                            if (filmesSugeridos.contains(filme.getTitulo())) {
                                System.out.println("Filme já foi sugerido");
                            } else {
                                System.out.println("Filme " + filmeSugerido + " sugerido.");
                                filmesSugeridos.add(filmeSugerido);
                                //teste se está sendo sugerido
                                System.out.println(filmesSugeridos);
                            }
                            break;
                        }
                }

         }else {
            System.out.println("Usuário não encontrado");
            System.out.println("Deseja cadastrar um novo usuário? (S/N)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                System.out.print("Digite o nome do usuário:");
                String nomeCadastro = scanner.nextLine();
                System.out.print("Digite o endereço do usuário:");
                String enderecoCadastro = scanner.nextLine();
                System.out.print("Digite a data de nascimento do usuário:");
                String dataNascimentoCadastro = scanner.nextLine();
                System.out.print("Cadastre a senha: ");
                String senhaCadastro = scanner.nextLine();
                Usuario newUser = new Usuario(nomeCadastro, enderecoCadastro, dataNascimentoCadastro, senhaCadastro);
                devinflix.addUser(newUser);
            }
        }}}}}