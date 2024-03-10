package Control;

import myTienda.Producto;

import java.util.HashMap;

public class TestRevasterser {
    public static void main(String[] args) {
        Producto p = new Producto();

        Tienda t = new Tienda();
        HashMap<String , Producto> productos = (HashMap<String, Producto>) t.deserialiarProducto();
        p=productos.get("P001");

        System.out.println(p.getCantidadInventario());
        productos = t.revasteser("P001",100);

        p=productos.get("P001");
        System.out.println(p.getCantidadInventario());


    }

}
