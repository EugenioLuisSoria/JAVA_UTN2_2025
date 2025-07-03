package cine.vista;

import cine.controlador.CompraController;
import cine.controlador.NavegacionController;
import cine.modelo.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SalaView extends VBox {

    public SalaView(Stage stage, Cine cine, Cliente cliente, NavegacionController nav) {
        setSpacing(40);
        setPadding(new Insets(40));

        CompraController compraController = new CompraController(cine);
        Label lblBienvenida = new Label("BIENVENIDO, " + cliente.getNombre().toUpperCase());

        Label lblTitulo = new Label("SELECCION de SALA y BUTACA");
        Label mensaje = new Label();
        GridPane gridButacas = new GridPane();
        Button btnComprar = new Button("CONFIRMAR COMPRA");
        Butaca[] seleccionada = new Butaca[1];

        HBox filaSalas = new HBox(10);
        for (Sala sala : cine.getSalas()) {
            Button btnSala = new Button("Sala " + sala.getNumero() + ": " + sala.getPelicula());
            btnSala.setOnAction(ev -> {
                gridButacas.getChildren().clear();
                seleccionada[0] = null;
                mensaje.setText("");

                Butaca[][] butacas = sala.getButacas();
                for (int i = 0; i < butacas.length; i++) {
                    for (int j = 0; j < butacas[i].length; j++) {
                        Butaca b = butacas[i][j];
                        Button btn = new Button((b.estaOcupada() ? "X" : "O"));
                        btn.setDisable(b.estaOcupada());
                        int fila = i;
                        int col = j;
                        btn.setOnAction(butacaEv -> {
                            seleccionada[0] = b;
                            mensaje.setText("Seleccionada: Fila " + fila + ", Asiento " + col);
                        });
                        gridButacas.add(btn, j, i);
                    }
                }

                // Guardar la sala seleccionada para la compra
                gridButacas.setUserData(sala);
            });
            filaSalas.getChildren().add(btnSala);
        }

        btnComprar.setOnAction(e -> {
            Sala sala = (Sala) gridButacas.getUserData();
            Butaca butaca = seleccionada[0];

            if (sala == null || butaca == null) {
                mensaje.setText("Debés seleccionar una sala y una butaca.");
                return;
            }

            Entrada entrada = compraController.comprarEntrada(cliente, sala, butaca);
            if (entrada != null) {
                mensaje.setText("COMPRA EXITOSA: \n" + entrada.resumen() + " para: \n " + sala.getPelicula());
                gridButacas.setUserData(null);  // limpiar selección
                gridButacas.getChildren().clear();
            } else {
                mensaje.setText("LA UBICACION NO SE ENCUENTRA DISPONIBLE.");
            }
        });

        getChildren().addAll(lblBienvenida, lblTitulo, filaSalas, gridButacas, btnComprar, mensaje);
    }
}
