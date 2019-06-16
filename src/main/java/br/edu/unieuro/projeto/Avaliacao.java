package br.edu.unieuro.projeto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Avaliacao {

    // Variavel estatica para guardar todos as avaliacoes
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
        // Espera ate que o usuario digite uma nota entre 1 e 5
        do {
            System.out.println("De 1 a 5, em quanto você avalia a" + oficina.getNome() + "?");
            nota = scanner.nextInt();
            avaliacao.setNota(nota);
        } while (nota < 1 || nota > 5);
        avaliacoes.add(getProximoId(), avaliacao);
    }

    public static void imprimeAvaliacoesPorOficina(Oficina oficina) {
        getAvaliacoesPorOficina(oficina).forEach(System.out::println);
    }

    private static List<Avaliacao> getAvaliacoesPorOficina(Oficina oficina) {
        // Filtra as avaliações que pertence a oficina expecificada pelo paramentro
        return avaliacoes.stream()
                .filter(avaliacao -> avaliacao != null && avaliacao.getOficina().getId() == oficina.getId())
                .collect(Collectors.toList());
    }

    public static double getMediaNotaPorOficina(Oficina oficina) {
        // Faz o mapeameto para a nota e calcula a média da oficina especificada pelo parametro
        return getAvaliacoesPorOficina(oficina).stream()
                .mapToDouble(Avaliacao::getNota)
                .average().orElse(0);
    }

    public void excluir() {
        //Para realizar a exclussão e nao baguçar os IDs, apenas faz a substutuilção da avaliação por um valor nulo
        avaliacoes.add((int) getId(), null);
    }

    // Retorna a proxima posição do ArrayList, para ser usada tambem como id
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

    @Override
    public String toString() {
        return "\nId: " + id +
                "\nData: " + data.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                "\nComentario: " + comentario +
                "\nNota: " + nota +
                "\nOficina: " + oficina.getNome() +
                '\n';
    }
}
