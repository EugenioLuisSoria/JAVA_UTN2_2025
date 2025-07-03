package cine.app;

import cine.controlador.NavegacionController;
import cine.modelo.Cine;
import cine.persistencia.PersistenciaDatos;
import cine.vista.LoginView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CineApp extends Application {

    private Cine cine;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        cine = PersistenciaDatos.cargar();

        cine.inicializarSalasSiEsNecesario();

        NavegacionController nav = new NavegacionController(stage, cine);
        stage.setWidth(500);
        stage.setHeight(700);
        nav.irALogin();

        stage.setOnCloseRequest(e -> PersistenciaDatos.guardar(cine));
        stage.show();
    }
}
