package cine.vista;

import cine.controlador.LoginController;
import cine.controlador.NavegacionController;
import cine.modelo.Cine;
import cine.modelo.Cliente;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends VBox {

    public LoginView(Stage stage, Cine cine, NavegacionController nav) {
        setSpacing(40);
        setPadding(new javafx.geometry.Insets(40));

        LoginController loginController = new LoginController(cine);

        Label lblNombre = new Label("NOMBRE:");
        TextField campoNombre = new TextField();

        Label lblEmail = new Label("EMAIL:");
        TextField campoEmail = new TextField();

        Label lblPass = new Label("CONTRASENIA:");
        PasswordField campoPass = new PasswordField();

        Button btnLogin = new Button("INICIAR SESIÓN");
        Button btnRegistro = new Button("REGISTRARSE");
        Label mensaje = new Label();

        btnLogin.setOnAction(e -> {
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String pass = campoPass.getText();

            Cliente cliente = loginController.login(nombre, email, pass);
            if (cliente != null) {
                mensaje.setText("HAS INGRESADO, " + cliente.getNombre().toUpperCase() + "!");
                nav.irASala(cliente);
            } else {
                mensaje.setText("NOMBRE, EMAIL y/o CONTRASENIA INCORRECTOS.");
            }
        });

        btnRegistro.setOnAction(e -> {
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String pass = campoPass.getText();

            boolean registrado = loginController.registrar(nombre, email, pass);

            if (registrado) {
                mensaje.setText("REGISTRADO! BIENVENIDO " + nombre.toUpperCase());
            } else {
                mensaje.setText("YA EXISTE UNA CUENTA CON ESE MAIL");
            }
        });

        getChildren().addAll(lblNombre, campoNombre, lblEmail, campoEmail, lblPass, campoPass, btnLogin, btnRegistro, mensaje);
    }
}
