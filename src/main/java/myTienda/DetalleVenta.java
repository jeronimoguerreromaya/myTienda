package myTienda;

import java.io.Serializable;

public class DetalleVenta implements Serializable {
    Producto producto;
    int cantidad;

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }
}

