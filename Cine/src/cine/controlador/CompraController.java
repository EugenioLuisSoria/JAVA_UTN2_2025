package cine.controlador;

import cine.modelo.*;

public class CompraController {

    private Cine cine;

    public CompraController(Cine cine) {
        this.cine = cine;
    }

    public boolean butacaDisponible(Butaca b) {
        return b != null && !b.estaOcupada();
    }

    public Entrada comprarEntrada(Cliente cliente, Sala sala, Butaca butaca) {
        if (butacaDisponible(butaca)) {
            butaca.ocupar();
            Entrada entrada = new Entrada(cliente, sala, butaca);
            cine.getEntradas().add(entrada);
            return entrada;
        }
        return null;
    }
}
