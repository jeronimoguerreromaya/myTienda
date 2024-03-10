package Control;

import myTienda.Venta;

import java.util.ArrayList;
import java.util.List;

public class TestVeriHistorial {

    public static void main(String[] args) {
        Tienda t = new Tienda();
        List<Venta> l = new ArrayList<>();

        l = (ArrayList<Venta>)t.deserialiarHistorico();

        System.out.println(l.size());

    }
}
