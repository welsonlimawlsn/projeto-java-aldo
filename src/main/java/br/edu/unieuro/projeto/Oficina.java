package br.edu.unieuro.projeto;


import java.util.ArrayList;
import java.util.Scanner;

public class Oficina {

    private static Scanner cadastro = new Scanner(System.in);
    private static ArrayList<Oficina> oficinas = new ArrayList<>();

    private long id;
    private String nome;
    private String telefone;
    private Endereco endereco;
    private Localizacao localizacao;

    public static void cadastroOficina() {
        Oficina oficina = new Oficina();
        
        oficina.setId(getProximoId());
                
        System.out.println("**CADASTRO OFICENA**");
        oficina.setId(getProximoId());
        System.out.println("Nome da oficina: ");
        oficina.setNome(cadastro.nextLine());
        System.out.println("Telefone: ");
        oficina.setTelefone(cadastro.nextLine());
        oficina.setEndereco(Endereco.cadastroEndereco());
        oficina.setLocalizacao(Localizacao.getNovaInstacia(oficina.getEndereco()));

        oficinas.add(getProximoId(), oficina);

    }

    static int getProximoId() {
        return oficinas.size();
    }
    static ArrayList<Oficina> getOficinas(){
        return oficinas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
