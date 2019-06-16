package br.edu.unieuro.projeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Avaliacao {

    private static ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private long id;
    private LocalDate data;
    private String comentario;
    private int nota;
    private Usuario usuario;
    private Oficina oficina;

    public static void novaAvaliacao(Oficina oficina) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(getProximoId());
        avaliacao.setData(LocalDate.now());
        avaliacao.setUsuario(Usuario.getUsuarioLogado());
        avaliacao.setOficina(oficina);
        System.out.println("Digite um comentario: ");
        avaliacao.setComentario(scanner.nextLine());
        int nota = 0;
        do {
            System.out.println("De 1 a 5, em quanto você avalia a" + oficina.getNome() + "?");
            nota = scanner.nextInt();
            avaliacao.setNota(nota);
        } while (nota < 1 || nota > 5);
        avaliacoes.add(getProximoId(), avaliacao);
    }

    private static int getProximoId() {
        return avaliacoes.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
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

    public static ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}
