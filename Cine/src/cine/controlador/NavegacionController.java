package cine.controlador;

import cine.modelo.Cine;
import cine.modelo.Cliente;
import cine.vista.LoginView;
import cine.vista.SalaView;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class NavegacionController {

    private final Stage stage;
    private final Cine cine;

    public NavegacionController(Stage stage, Cine cine) {
        this.stage = stage;
        this.cine = cine;
    }

    public void irALogin() {
        LoginView login = new LoginView(stage, cine, this);
        stage.setScene(new Scene(login));
        stage.setTitle("CINE - Login");
    }

    public void irASala(Cliente cliente) {
        SalaView sala = new SalaView(stage, cine, cliente, this);
        stage.setScene(new Scene(sala));
        stage.setTitle("CINE - Seleccion Sala");
    }

}
