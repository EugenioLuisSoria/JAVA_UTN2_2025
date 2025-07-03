package cine.modelo;

import java.io.Serializable;

public class Entrada implements Serializable {
    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;

    public Entrada(Cliente cliente, Sala sala, Butaca butaca) {
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }

    public String resumen() {
        return cliente.getNombre() + " – SALA " + sala.getNumero() + " – FILA " + butaca.getFila() + ", ASIENTO " + butaca.getNumero();
    }
}
