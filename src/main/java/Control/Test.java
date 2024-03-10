package Control;
import myTienda.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Producto producto1 = new Producto("P001", "Manzanas", 0.75, 100);
        Producto producto2 = new Producto("P002", "Leche entera", 1.25, 100);
        Producto producto3 = new Producto("P003", "Pasta espagueti", 1.99, 100);
        Producto producto4 = new Producto("P004", "Pollo entero", 6.99, 100);
        Producto producto5 = new Producto("P005", "Pan integral", 2.50, 100);
        Producto producto6 = new Producto("P006", "Queso cheddar", 3.75, 100);
        Producto producto7 = new Producto("P007", "Huevos (docena)", 2.99, 100);
        Producto producto8 = new Producto("P008", "Yogur natural", 0.99, 100);
        Producto producto9 = new Producto("P009", "Arroz blanco", 1.25, 100);
        Producto producto10 = new Producto("P010", "Filetes de salmón", 8.99, 100);


        HashMap<String, Producto> l = new HashMap<>();

        l.put("P001",producto1);
        l.put("P002",producto2);
        l.put("P003",producto3);
        l.put("P004",producto4);

        Tienda t = new Tienda();

        t.serialiarProducto(l);
        HashMap<String,Producto> productos;
        productos = (HashMap<String, Producto>) t.deserialiarProducto();
        System.out.println(productos.get("P004"));
        ArrayList<String> productosComenzandoConP00 = new ArrayList<>();
        productosComenzandoConP00.add(producto1.getCodigo());
        productosComenzandoConP00.add(producto2.getCodigo());
        productosComenzandoConP00.add(producto3.getCodigo());
        productosComenzandoConP00.add(producto4.getCodigo());


        t.serialiarCodigos(productosComenzandoConP00);

    }
}
