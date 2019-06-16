package br.edu.unieuro.projeto;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Scanner;

public class Agendamento {

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Agendamento> agendamentos = new ArrayList<>();

    private long id;
    private Usuario usuario;
    private Oficina oficina;
    private LocalDateTime data;
    private String descricao;

    public static void novoAgendamento(Oficina oficina) {
        Agendamento agendamento = new Agendamento();
        agendamento.setUsuario(Usuario.getUsuarioLogado());
        agendamento.setOficina(oficina);
        agendamento.setId(getProximoId());

        System.out.println("Descreva o serviço de deseja: ");
        agendamento.setDescricao(scanner.nextLine());

        setDataScanner(agendamento);

        agendamentos.add(getProximoId(), agendamento);

        System.out.println("Agendado com sucesso!");
        System.out.println(agendamento);

    }

    private static void setDataScanner(Agendamento agendamento) {
        System.out.println("Escolha a data: ");
        System.out.print("Dia: ");
        int dia = Integer.parseInt(scanner.nextLine());

        System.out.print("Mes: ");
        int mes = Integer.parseInt(scanner.nextLine());

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Hora: ");
        int hora = Integer.parseInt(scanner.nextLine());

        System.out.print("Minutos: ");
        int minutos = Integer.parseInt(scanner.nextLine());

        try {
            agendamento.setData(LocalDateTime.of(ano, mes, dia, hora, minutos));
        } catch (DateTimeException e) {
            System.out.println("Data invalida, escolha outra!");
            setDataScanner(agendamento);
        }
    }

    public static void todosAgendamentos() {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento != null && agendamento.getUsuario().getId() == Usuario.getUsuarioLogado().getId()) {
                System.out.println("////////////////////////////////////////////////////////////");
                System.out.println(agendamento);
                System.out.println("////////////////////////////////////////////////////////////");
            }
        }
    }

    public static int getProximoId() {
        return agendamentos.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Identificação: " + getId() +
                "\nNome da Oficina: " + getOficina().getNome() +
                "\nData: " + getData().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                "\nDescrição: " + getDescricao() + "\n";
    }
}
