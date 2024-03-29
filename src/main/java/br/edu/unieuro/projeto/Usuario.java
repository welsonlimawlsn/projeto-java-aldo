package br.edu.unieuro.projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private static Scanner ler = new Scanner(System.in);
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    private long id;        //criação dos atributos tipo private para não serem alterados por outra classe
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private static Usuario usuarioLogado;

    public static void cadastroUsuario() {

        Usuario usuario = new Usuario();

        usuario.setId(getProximoId());

        System.out.println("**CADASTRO DE USUÁRIO**");
        System.out.println("Isira o nome do usuário: ");
        usuario.setNome(ler.nextLine());
        System.out.println("Isira o sobrenome do usuário: ");
        usuario.setSobrenome(ler.nextLine());
        System.out.println("insira o email do usuário: ");
        usuario.setEmail(ler.nextLine());
        System.out.println("Crie uma senha: ");
        usuario.setSenha(ler.nextLine());
        usuarios.add(getProximoId(), usuario);

    }

    public static boolean fazerLogin() {
        ler = new Scanner(System.in);
        System.out.println("Digite o e-mail: ");
        String email = ler.nextLine();
        System.out.println("Digite a senha: ");
        String senha = ler.nextLine();
        for (Usuario u : usuarios) {
            if (u != null && u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                usuarioLogado = u;
                return true;
            }
        }
        return false;
    }

    private static int getProximoId() {
        return usuarios.size();
    }

    public static void imprimirUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
//criação dos sets e gets para serem chamados por outros modos
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Cadastro nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Cadastro sobrenome
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha=" + senha + '}';
    }

    public void alterarCadastro() { //metodo alterar cadastro!
        int opt = 0;
        do {
            ler = new Scanner(System.in);                      
            System.out.println("ALTERAÇÃO CADASTRAL");
            System.out.println("1 - Alterar nome:");
            System.out.println("2 - Alterar sobrenome:");
            System.out.println("3 - Alterar email");
            System.out.println("4 - Alterar senha");
            System.out.println("5 - Sair");
            opt = Integer.parseInt(ler.nextLine());


            switch (opt) { //cada caso vai alterar o que esta na variavel.
                case 1:
                    System.out.println(getNome());
                    System.out.println("Insira o novo nome: ");
                    setNome(ler.nextLine());
                    break;

                case 2:
                    System.out.println(getSobrenome());
                    System.out.println("Insira o novo sobrenome: ");
                    setSobrenome(ler.nextLine());
                    break;

                case 3:
                    System.out.println(getEmail());
                    System.out.println("Insira o novo email: ");
                    setEmail(ler.nextLine());
                    break;

                case 4:
                    System.out.println(getSenha());
                    System.out.println("Insira a nova senha: ");
                    setSenha(ler.nextLine());
                    break;
            }
        } while (opt < 5);
    }
}
