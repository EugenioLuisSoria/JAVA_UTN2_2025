package cine.controlador;

import cine.modelo.Cine;
import cine.modelo.Cliente;

public class LoginController {

    private Cine cine;

    public LoginController(Cine cine) {
        this.cine = cine;
    }

    public Cliente login(String nombre, String email, String contr) {
        Cliente cliente = cine.buscarCliente(email);
        if (cliente != null &&
            cliente.getNombre().equalsIgnoreCase(nombre) &&
            cliente.validarContraseña(contr)) {
            return cliente;
        }
        return null;
    }

    public boolean registrar(String nombre, String email, String contr) {
        if (cine.buscarCliente(email) == null) {
            Cliente nuevo = new Cliente(nombre, email, contr);
            cine.getClientes().add(nuevo);
            return true;
        }
        return false;
    }
}
