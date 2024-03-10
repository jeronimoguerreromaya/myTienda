package Control;
import myTienda.*;
import java.util.*;

public class TestCliente {

    public static void main(String[] args) {
        // Crear un HashMap para almacenar clientes

        Map<String, Cliente> clientes = new HashMap<>();

        // Generar algunos clientes aleatorios
        Cliente cliente1 = new Cliente("12345", "Juan Pérez", "Calle Principal 123");
        Cliente cliente2 = new Cliente("67890", "María Rodríguez", "Avenida Central 456");
        Cliente cliente3 = new Cliente("54321", "Pedro Gómez", "Plaza Mayor 789");

        // Agregar los clientes al HashMap
        clientes.put(cliente1.getIdentificacion(), cliente1);
        clientes.put(cliente2.getIdentificacion(), cliente2);
        clientes.put(cliente3.getIdentificacion(), cliente3);

        // Acceder a un cliente por su número de identificación
        String idBuscado = "67890";
        Cliente clienteEncontrado = clientes.get(idBuscado);
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nombre: " + clienteEncontrado.getNombre());
            System.out.println("Dirección: " + clienteEncontrado.getDireccion());
        } else {
            System.out.println("Cliente con identificación " + idBuscado + " no encontrado.");
        }
        Tienda t = new Tienda();

        t.serialiarPersona(clientes);

        HashMap<String,Cliente> x = new HashMap<>();

        x = (HashMap<String, Cliente>) t.deserialiarPersona();
        if(x.containsKey("1234500000000000000")){
            System.out.println("existe");
        }else{
            System.out.println("no existe");
        }
    }


}

