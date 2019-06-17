package br.edu.unieuro.projeto;

import java.util.ArrayList;
import java.util.Scanner;


public class Principal {

    private static Scanner ler = new Scanner(System.in);

    private static int controleMenuUm;
    private static int controleMenuDois;
    private static int controleMenuOficina;
    private static int controleMunuAvaliacoes;
    private static int controleMenuAgendamento;

    public static void main(String[] args) {
        System.out.println("BEM-VINDO AO FEMCAR");
        do {
            menuUm();
        } while (controleMenuUm != 4);
    }

    private static void menuUm() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1 - Fazer login");
        System.out.println("2 - Fazer cadastro");
        System.out.println("3 - Cadastrar oficina");
        System.out.println("4 - Sair");

        controleMenuUm = ler.nextInt();

        if (controleMenuUm == 1) {
            boolean fezLogin = Usuario.fazerLogin();
            if (fezLogin) {
                do {
                    menuDois();
                } while (controleMenuDois != 5);
            } else {
                System.out.println("Email e senha invalidos!");
                menuUm();
            }
        } else if (controleMenuUm == 2) {
            Usuario.cadastroUsuario();
            menuUm();
        } else if (controleMenuUm == 3) {
            Oficina.cadastroOficina();
            menuUm();
        }
    }

    private static void menuDois() {
        System.out.println("Seja bem-vindo(a) " + Usuario.getUsuarioLogado().getNome());
        System.out.println("1 - Ver oficinas");
        System.out.println("2 - Ver avaliações feitas");
        System.out.println("3 - Ver agendamentos");
        System.out.println("4 - Alterar conta");
        System.out.println("5 - Sair");

        controleMenuDois = ler.nextInt();

        if (controleMenuDois == 1) {
            do {
                menuOficina();
            } while (controleMenuOficina != -1);//Colocar opção de saida
        } else if (controleMenuDois == 2) {
            do {
                menuAvaliacoesFeitas();
            } while (controleMunuAvaliacoes != -1);//Colocar opcao de saida
        } else if (controleMenuDois == 3) {
            do {
                menuAgendamentos();
            } while (controleMenuAgendamento != -1);//Colocar opção de saida
        } else if (controleMenuDois == 4) {
            Usuario.getUsuarioLogado().alterarCadastro();
        }
    }
    private static void menuTres(){
        System.out.println ("Seja bem vindo ao cadastro de oficinas!!");
        System.out.println ("1 - Efetuar cadastro");
        System.out.println ("2 - Ver oficinas");
        System.out.println ("3 - Ver avaliações");
        System.out.println ("4 - Sair");
        
    
        }
    

    private static void menuAgendamentos() {

    }

    private static void menuAvaliacoesFeitas() {

    }

    private static void menuOficina() {
        
        
       for(int i = 0;i < Oficina.getOficinas().size();i++){
           Oficina oficina = Oficina.getOficinas().get(i);
           System.out.println(oficina.getId()+"-"+oficina.getNome());
        }
    controleMenuOficina = ler.nextInt();
    }
}
