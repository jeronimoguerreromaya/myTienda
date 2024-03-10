package Control;
import java.io.*;
import java.util.*;
import myTienda.*;
public class Tienda {

    private static Map<String, Producto> listProductos = new HashMap<>();
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static Set<String> carritoCompras = new HashSet<>();
    private  static List<Venta> historialVentas = new LinkedList<>();

    public Tienda(){}
    private static void registrarCliente(String identificacion,String nombre,String direccion) {

        Cliente cliente = new Cliente(identificacion, nombre, direccion);
        clientes.put(identificacion, cliente);
        System.out.println("Cliente registrado correctamente.");
    }


    // Métodos para listProductos
    public static Producto getProducto(String codigo) {
        return listProductos.get(codigo);
    }

    public static void agregarProducto(Producto producto) {
        listProductos.put(producto.getCodigo(), producto);
    }

    // Métodos para clientes
    public static Cliente getCliente(String codigo) {
        return clientes.get(codigo);
    }

    public static void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getIdentificacion(), cliente);
    }

    // Métodos para carritoCompras
    public static boolean estaEnCarrito(String codigoProducto) {
        return carritoCompras.contains(codigoProducto);
    }

    public static void agregarAlCarrito(String codigoProducto) {
        carritoCompras.add(codigoProducto);
    }

    public static void eliminarDelCarrito(String codigoProducto) {
        carritoCompras.remove(codigoProducto);
    }

    // Métodos para historialVentas
    public static List<Venta> getHistorialVentas() {
        return historialVentas;
    }

    public static void agregarVenta(Venta venta) {
        historialVentas.add(venta);
    }


    public void realizarVenta(List<DetalleVenta> listaDetalles, Cliente cliente) {
        Producto productoAxl = new Producto();
        Venta venta = new Venta(cliente,listaDetalles);

        //venta.agregarDetalle( listaDetalles);

        //dv variable auxiliar para que tomar un valr de objeto DetalleVenta
        HashMap<String,Producto> list = (HashMap<String, Producto>) deserialiarProducto();
        for(DetalleVenta dv: listaDetalles){

            productoAxl = dv.getProducto();
            productoAxl.setCantidadInventario(productoAxl.getCantidadInventario()- dv.getCantidad());

            list.put(productoAxl.getCodigo(),productoAxl);
        }
        serialiarProducto(list);

        List<Venta> listAx = new ArrayList<>();
        listAx = (ArrayList<Venta>) deserialiarHistorico();
        listAx.add(venta);
        serialiarHistorico((ArrayList<Venta>) listAx);




        System.out.println("Venta exitosa \n Su compra fue: \n");
        for(DetalleVenta dv: listaDetalles){
            productoAxl = dv.getProducto();
            System.out.println("[Nombre: "+productoAxl.getNombre()+" ] [Cantidad: "+dv.getCantidad()+" ] [Precios: "+productoAxl.getPrecio()+"]");
        }




    }
    public  void  serialiarProducto(Map<String,Producto> miMap){

        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/Files/Productos1.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(miMap);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String,Producto> deserialiarProducto() {

        Map<String, Producto> miMapDeserializado = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/Files/Productos1.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            miMapDeserializado = (HashMap<String, Producto>) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return miMapDeserializado;
    }
    public  void  serialiarPersona(Map<String,Cliente> miMap){

        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/Files/Cliente1.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(miMap);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String,Cliente> deserialiarPersona() {

        Map<String, Cliente> miMapDeserializado = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/Files/Cliente1.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            miMapDeserializado = (HashMap<String, Cliente>) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return miMapDeserializado;
    }

    public HashMap<String,Producto> revasteser(String codigo, int cantidadNuevosProductos){
        Producto p;
        HashMap<String , Producto> productos = (HashMap<String, Producto>) deserialiarProducto();
        p=productos.get(codigo);

        p.setCantidadInventario(p.getCantidadInventario()+cantidadNuevosProductos);

        listProductos.put(codigo,p);

        return  productos;

    }
    public void imprimirStock( HashMap<String,Producto> produtos){
        ArrayList<String> codigos = deserialiarCodigos();
        Producto p = new Producto();
        for(String code: codigos){
            p = produtos.get(code);
            System.out.println("[Codigo: "+p.getCodigo()+"] [Nombre: "+p.getNombre()+"] [Precio: "+p.getPrecio()+"]" );
        }

    }
    public  void  serialiarCodigos(ArrayList<String> miMap){

        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/Files/Codigos.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(miMap);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> deserialiarCodigos() {

        ArrayList<String> miMapDeserializado = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/Files/Codigos.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            miMapDeserializado = (ArrayList<String>) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return miMapDeserializado;
    }

    public DetalleVenta agregarDetalleVenta(String codigo, int c){

        Map<String,Producto> listAXL = deserialiarProducto();


        DetalleVenta d = new DetalleVenta(listAXL.get(codigo),c);
        return d;
    }
    public  int validarCampos(String code, int cantidad){
        try{
            if(!code.isEmpty() && cantidad > 0 ){
                return 1;
            }else{

                return -1;
            }
        }catch (RuntimeException e){
            System.out.println("campos invalidos");
            return -1;
        }



    }
    public int validarCliente (String numIdentificacion){
        Map<String,Cliente> cliente = new HashMap<>();
        cliente = (HashMap<String, Cliente>) deserialiarPersona();
        if(cliente.containsKey(numIdentificacion)){

            return 1;
        }else {
            return -1;
        }

    }
    public  void  serialiarHistorico(ArrayList<Venta> milist){

        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/Files/Historico1.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(milist);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Venta> deserialiarHistorico() {

        ArrayList<Venta> miDeserializado = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/Files/Historico1.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            miDeserializado = (ArrayList<Venta>) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return miDeserializado;
    }
}
