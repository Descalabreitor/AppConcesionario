package File;

import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static Model.Concesionario.*;

public class recuperarDatos {

    public static ArrayList<Cliente> recuperarClientes() throws IOException {
        BufferedReader lector = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            lector = new BufferedReader(new FileReader("Clientes.csv"));
            String encabezado = lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                System.out.println(Arrays.toString(lineaDividida));
                Cliente cliente = new Cliente(lineaDividida[0],Integer.parseInt(lineaDividida[1]),lineaDividida[2],lineaDividida[3],lineaDividida[4],lineaDividida[5]);
                ArrayList<Pedido> pedidos = recuperarPedidosCliente(lineaDividida[3]);
                añadirPedidosAlCliente(pedidos,cliente);
                clientes.add(cliente);
                linea = lector.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
            return clientes;
        }
    }

    private static void añadirPedidosAlCliente(ArrayList<Pedido> pedidos, Cliente cliente) {
        for (int i = 0; i<pedidos.size(); i++){
            cliente.addPedido(pedidos.get(i));
        }
    }

    private static ArrayList<Pedido> recuperarPedidosCliente(String dni) {
        return new ArrayList<Pedido>(getPedidos().stream().filter(pedido -> pedido.getCliente().getDni().equalsIgnoreCase(dni.trim())).collect(Collectors.toList()));
    }

    public static ArrayList<Modelo> recuperarModelos() throws IOException {
        BufferedReader lector = null;
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        try {

            lector = new BufferedReader(new FileReader("Modelos.csv"));
            String encabezado = lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {

                String[] lineaDividida = linea.split(";");
                System.out.println(Arrays.toString(lineaDividida));
                ArrayList<Extra> extrasDisponibles = recuperarExtrasDeObjeto(lineaDividida[4]);
                ArrayList<Integer> vehiculosDisponibles = recuperarVehiculosDisponibles(lineaDividida[1]);
                Modelo modelo = new Modelo(lineaDividida[0], vehiculosDisponibles, Integer.parseInt(lineaDividida[2]),Integer.parseInt(lineaDividida[3]), extrasDisponibles);
                añadirComentarios(modelo,lineaDividida[5]);
                modelos.add(modelo);
                linea = lector.readLine();
            }

        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();

            }
        }
        return modelos;
    }

    private static void añadirComentarios(Modelo modelo, String comentarios) {

        if (comentarios.length()>9){
            String[] comentariosLista = comentarios.substring(1,comentarios.length()-1).split(",");
            for (String comentario:comentariosLista) {
                String autor = comentario.substring(0,9);
                modelo.addComentario(comentario.substring(10), comentario.substring(0,9));
        }
        }
    }

    private static ArrayList<Integer> recuperarVehiculosDisponibles(String listaDeInts) {
        String[] nombresDeExtras = listaDeInts.substring(1,listaDeInts.length()-1).split(",");
        ArrayList<Integer> vehiculosDisponibles = new ArrayList<Integer>();
        for(String nombre:nombresDeExtras){
            vehiculosDisponibles.add(Integer.parseInt(nombre.trim()));
        }
        return vehiculosDisponibles;
    }

    private static ArrayList<Extra> recuperarExtrasDeObjeto(String listaDeExtras) {
        String[] nombresDeExtras = listaDeExtras.substring(1,listaDeExtras.length()-1).split(",");
        ArrayList<Extra> extras = getExtras();
        ArrayList<Extra> extrasBuscados = new ArrayList<Extra>();
        for (int i=0;i<nombresDeExtras.length;i++){
            String nombreExtra=nombresDeExtras[i].trim();
            extrasBuscados.add(extras.stream().filter(extra -> extra.getNombre().equalsIgnoreCase(nombreExtra)).findFirst().orElse(null));
        }
        return extrasBuscados;
    }

    public static ArrayList<Pedido> recuperarPedidos() throws IOException {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        BufferedReader lector = null;
        try {

            lector = new BufferedReader(new FileReader("Pedidos.csv"));
            String encabezado = lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                System.out.println(Arrays.toString(lineaDividida));
                Cliente cliente = recuperarClienteDePedido(lineaDividida);
                Modelo modelo = recuperarModeloDePedido(lineaDividida);
                ArrayList<Extra> extras = recuperarExtrasDeObjeto(lineaDividida[2]);
                Pedido pedido = new Pedido(cliente,modelo,extras);
                pedidos.add(pedido);
                linea = lector.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
            return pedidos;
        }
    }

    private static Modelo recuperarModeloDePedido(String[] lineaDividida) {
        ArrayList<Modelo> modelos = getModelos();
        return modelos.stream().filter(modelo -> modelo.getIdModelo() == Integer.parseInt(lineaDividida[1])).findFirst().orElse(null);
    }

    private static Cliente recuperarClienteDePedido(String[] lineaDividida) {
        ArrayList<Cliente> clientes = getClientes();
        return clientes.stream().filter(cliente -> cliente.getDni() == lineaDividida[0]).findFirst().orElse(null);
    }

    public static ArrayList<Vehiculo> recuperarVehiculos() throws IOException {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        BufferedReader lector = null;
        try {

            lector = new BufferedReader(new FileReader("Vehiculos.csv"));
            String encabezado = lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaSeparada = linea.split(";");
                System.out.println(Arrays.toString(lineaSeparada));

                Vehiculo vehiculo = new Vehiculo(Boolean.parseBoolean(lineaSeparada[0]),Integer.parseInt(lineaSeparada[1]));
                vehiculos.add(vehiculo);
                linea = lector.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
            return vehiculos;
        }
    }

    public static ArrayList<Extra>recuperarExtras() throws IOException {
        ArrayList<Extra> extras = new ArrayList<Extra>();
        BufferedReader lector = null;
        try {

            lector = new BufferedReader(new FileReader("Extras.csv"));
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaSeparada = linea.split(";");
                System.out.println(Arrays.toString(lineaSeparada));
                Extra extra = new Extra(lineaSeparada[0],lineaSeparada[1],Integer.parseInt(lineaSeparada[2]));
                extras.add(extra);
                linea = lector.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
            return extras;
        }
    }

}


