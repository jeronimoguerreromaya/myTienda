package myTienda;
import java.io.Serializable;
import java.util.*;
public class Venta implements Serializable {
    Cliente cliente;
    List<DetalleVenta> detalles;

    public Venta(){}
    public Venta(Cliente cliente,List<DetalleVenta> detalleVenta) {
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleVenta detalle) {

        detalles.add(detalle);
    }

    public Cliente getCliente(){
        return cliente;
    }

}
