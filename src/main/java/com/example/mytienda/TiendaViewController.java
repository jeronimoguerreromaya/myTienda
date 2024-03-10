package com.example.mytienda;

import Control.Tienda;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import myTienda.Cliente;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TiendaViewController {
    Tienda tieneda;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField addres;

    public void onRegistrarClick(){
        tieneda = new Tienda();
        Map<String, Cliente> list = new HashMap<>();
        Cliente newClient = new Cliente();

        String newid = id.getText();
        String  newName = name.getText();
        String newAddres = addres.getText();

        if(list.containsKey(newid)){
            System.out.println("cliente ya existe");
            id.clear();name.clear();addres.clear();
        }else{
            newClient.setIdentificacion(newid);
            newClient.setNombre(newName);
            newClient.setDireccion(newAddres);

           list.put(newid,newClient);

           tieneda.serialiarPersona(list);
            System.out.println("Cliente registrado");

            id.clear();name.clear();addres.clear();

        }
    }
}
