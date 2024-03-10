package com.example.mytienda;
import java.util.*;
import Control.Tienda;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import myTienda.*;
import Control.*;


import java.util.List;

public class VentaController {
    private List<DetalleVenta> detalles = new ArrayList<>();
    HashMap<String, Producto> productos ;
    private Tienda tienda;
    @FXML
    private TextField codigoProducto;
    @FXML
    private  TextField cantidad;
    @FXML
    private TableView<Producto> stock;
    @FXML
    private TableColumn<Producto,String> codigoTB;
    @FXML
    private TableColumn<Producto,String> productoTB;
    @FXML
    private TableColumn<Producto,Integer> precio;

    public void initialize() {
        tienda = new Tienda();
        tienda = new Tienda();
        HashMap<String ,Producto> productos = (HashMap<String, Producto>) tienda.deserialiarProducto();

        tienda.imprimirStock(productos);

    }
    public void axlB(){


    }
    public void agregarCarritoButton(){
        tienda = new Tienda();

        int catidad=-1;
        if(!cantidad.getText().isEmpty()){
            catidad = Integer.parseInt(cantidad.getText());
        }
        String code = codigoProducto.getText();
        if(tienda.validarCampos(code,catidad) == 1){

            detalles.add(tienda.agregarDetalleVenta(code,catidad));
            System.out.println(" Se Agrego: "+"[Code "+code+" Catidad "+catidad);

            codigoProducto.clear();
            cantidad.clear();
        }else{
            System.out.println("Campos invalidos");
        }
    }

    public void finalizarCompraButton(){
        tienda = new Tienda();
        Map<String,Cliente>  ax = new HashMap<>();
        Cliente clienteAx = new Cliente();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su numero de identificacion:");
        String userInput = scanner.nextLine();

        ax = tienda.deserialiarPersona();

        clienteAx = ax.get(userInput);

        if(tienda.validarCliente(userInput)==1 ){
            tienda.realizarVenta(detalles,clienteAx);

        }else {
            System.out.println("Cliente no encontrado");
        }

    }
    public void stock(){

    }

}
