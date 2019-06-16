package br.edu.unieuro.projeto;

import java.util.Scanner;


public class Principal {

    private static Scanner ler = new Scanner(System.in);

    private static int controleMenuUm;
    private static int controleMenuDois;
    private static int controleMenuOficina;
    private static int controleMunuAvaliacoes;
    private static int controleMenuMostraDetalhesOficina;

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
            mostrarAgendamentos();
        } else if (controleMenuDois == 4) {
            Usuario.getUsuarioLogado().alterarCadastro();
        }
    }

    private static void mostrarAgendamentos() {
        Agendamento.todosAgendamentos();
    }

    private static void menuAvaliacoesFeitas() {
        for (Avaliacao avaliacao : Avaliacao.getAvaliacoes()) {
            System.out.println(avaliacao);
        }
        System.out.println("Caso queira excluir alguma avaliacao, digite o Id dela, caso queira sair digite -1:");
        controleMunuAvaliacoes = ler.nextInt();

        if (controleMenuOficina >= 0 && Avaliacao.getAvaliacoes().get(controleMunuAvaliacoes) != null) {
            Avaliacao.getAvaliacoes().get(controleMunuAvaliacoes).excluir();
            System.out.println("Avaliacao excluida com sucesso!");
        }
    }

    private static void menuOficina() {
        for (int i = 0; i < Oficina.getOficinas().size(); i++) {
            Oficina oficina = Oficina.getOficinas().get(i);
            System.out.println(oficina.getId() + " - " + oficina.getNome() + " - " + oficina.getNotaMedia());
        }
        controleMenuOficina = ler.nextInt();
        if (controleMenuOficina >= 0 && Oficina.getOficinas().get(controleMenuOficina) != null) {
            menuMostraDetalhesOficina(Oficina.getOficinas().get(controleMenuOficina));
        }
    }

    private static void menuMostraDetalhesOficina(Oficina oficina) {
        System.out.println("Nome: " + oficina.getNome());
        System.out.println("Telefone: " + oficina.getTelefone());
        System.out.println("Nota: " + oficina.getNotaMedia());
        System.out.println("Endereço: " + oficina.getEndereco());

        System.out.println("Avaliações: ");
        oficina.imprimiAvaliacoes();

        System.out.println("-1 - Voltar");
        System.out.println("1 - Fazer agendamento");
        System.out.println("2 - Fazer avaliacao");

        controleMenuMostraDetalhesOficina = ler.nextInt();

        if (controleMenuMostraDetalhesOficina == 1) {
            Agendamento.novoAgendamento(oficina);
            System.out.println("Agendamento realizado");
        } else if (controleMenuMostraDetalhesOficina == 2) {
            Avaliacao.novaAvaliacao(oficina);
            System.out.println("Avaliacao realizada");
        }
    }
}
