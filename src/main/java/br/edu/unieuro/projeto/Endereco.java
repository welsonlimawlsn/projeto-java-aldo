package br.edu.unieuro.projeto;


import java.util.Scanner;

public class Endereco {

    static Scanner add = new Scanner(System.in);

    private String rua;
    private int numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;


    public static Endereco cadastroEndereco() {
        Endereco endereco = new Endereco();

        System.out.println("Insira a rua: ");
        endereco.setRua(add.nextLine());
        System.out.println("Número: ");
        endereco.setNumero(Integer.parseInt(add.nextLine()));
        System.out.println("Complemento: ");
        endereco.setComplemento(add.nextLine());
        System.out.println("Cidade: ");
        endereco.setCidade(add.nextLine());
        System.out.println("Estado: ");
        endereco.setEstado(add.nextLine());
        System.out.println("CEP: ");
        endereco.setCep(add.nextLine());

        return endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return getRua() + " " + getNumero() + ", " + getComplemento() + " - " + getCidade() + " - " + getEstado() + " - " + getCep();
    }
}
