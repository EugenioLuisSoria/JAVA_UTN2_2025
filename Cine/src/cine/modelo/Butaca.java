package cine.modelo;

import java.io.Serializable;

public class Butaca implements Serializable {
    private int fila;
    private int numero;
    private boolean ocupada;

    public Butaca(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.ocupada = false;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public int getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }
}