package Control;

import myTienda.DetalleVenta;
import myTienda.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestVender {
    public static void main(String[] args) {
        Tienda t = new Tienda();

        List<DetalleVenta> d = new ArrayList<>();
        DetalleVenta dv , dv2 ,dv3 ;


        HashMap<String ,Producto> productos = (HashMap<String, Producto>) t.deserialiarProducto();

        dv= new DetalleVenta(productos.get("P001"),5);
        dv3= new DetalleVenta(productos.get("P003"),5);
        dv2= new DetalleVenta(productos.get("P002"),5);

        d.add(dv);d.add(dv2);d.add(dv3);

        t.realizarVenta(d,null);


        System.out.println("Nuevas cantidadades");
        for(DetalleVenta x: d){
            Producto z = new Producto();
            z.setNombre(String.valueOf(productos.get(x.getProducto().getCodigo())));
            z.setCantidadInventario(productos.get(x.getProducto().getCodigo()).getCantidadInventario());
            System.out.println(z.getNombre()+" "+z.getCantidadInventario());
        }

    }



}
