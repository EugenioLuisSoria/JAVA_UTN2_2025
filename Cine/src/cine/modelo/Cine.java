package cine.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cine implements Serializable {

    private List<Sala> salas;
    private List<Entrada> entradas;
    private List<Cliente> clientes;

    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void inicializarSalasSiEsNecesario() {
        if (salas.isEmpty()) {
            salas.add(new Sala(1, "JAVA The Hut, a life with Objetives", 4, 6));
            salas.add(new Sala(2, "The Python", 6, 4));
            clientes.add(new Cliente("z", "z", "z"));
        }
    }

    public Cliente buscarCliente(String email) {
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

}
