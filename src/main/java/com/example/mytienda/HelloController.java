package com.example.mytienda;

import Control.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import myTienda.Venta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;



    public void onRegistrarClienteClick(ActionEvent actionEvent) {
        try {
            // Cargar el archivo FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registarClienteView.fxml"));
            Pane root = loader.load();

            // Crear una nueva escena y un nuevo Stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            // Configurar y mostrar la nueva ventana
            stage.setTitle("Nueva Ventana");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onVenderClick(ActionEvent actionEvent) {
        try {
            // Cargar el archivo FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentaView.fxml"));
            Pane root = loader.load();

            // Crear una nueva escena y un nuevo Stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            // Configurar y mostrar la nueva ventana
            stage.setTitle("Nueva Ventana");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onVerHistorialClick(ActionEvent actionEvent) {
        Tienda t = new Tienda();
        List<Venta> list= new ArrayList<>();

        list = (ArrayList<Venta>)t.deserialiarHistorico();

        for(Venta v: list){
            System.out.println(v.getCliente().getIdentificacion());
    }
    }
}