package br.edu.unieuro.projeto;

import java.util.Random;

public class Localizacao {

    private double latitude;
    private double longitude;

    public Localizacao() {
    }

    public Localizacao(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Criar uma nota instacia "a partir" do endereço, cria um valor randomico
    public static Localizacao getNovaInstacia(Endereco endereco) {
        Random random = new Random();
        double latitude = Math.random() * random.nextInt(90);
        double longitude = Math.random() * random.nextInt(180);
        return new Localizacao(random.nextInt(2) == 1 ? latitude : -latitude, random.nextInt(2) == 1 ? longitude : -longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
