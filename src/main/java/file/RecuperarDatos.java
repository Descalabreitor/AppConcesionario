/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static Model.Concesionario.*;
/**
 *
 * @author david
 */
public class RecuperarDatos {
    public static ArrayList<Cliente> recuperarClientes() throws IOException {
        BufferedReader lector = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            lector = new BufferedReader(new FileReader("Clientes.csv"));
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                System.out.println(Arrays.toString(lineaDividida));
                Cliente cliente = new Cliente(lineaDividida[0],Integer.parseInt(lineaDividida[1]),lineaDividida[2],lineaDividida[3],lineaDividida[4],lineaDividida[5]);
                ArrayList<Pedido> pedidos = recuperarPedidosCliente(lineaDividida);
                añadirPedidosAlCliente(pedidos,cliente);
                clientes.add(cliente);


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

    private static ArrayList<Pedido> recuperarPedidosCliente(String[] lineaDividida) {

        String[] ids = lineaDividida[6].substring(1,lineaDividida[6].length()-1).split(",");

        //La linea anterior es una lista de ids de los pedidos de ese cliente, necesito la lista total de pedidos para sacar los pedidos de esos ids
    }

    public static ArrayList<Modelo> recuperarModelos() throws IOException {
        BufferedReader lector = null;
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        try {

            lector = new BufferedReader(new FileReader("Modelos.csv"));
            String linea = lector.readLine();
            while (null != linea) {

                String[] lineaDividida = linea.split(";");
                System.out.println(Arrays.toString(lineaDividida));
                Vehiculo vehiculoDisponible = recuperarVehiculoDisponible(lineaDividida);
                ArrayList<Extra> extrasDisponibles = recuperarExtrasDelVehiculo(lineaDividida);
                Modelo modelo = new Modelo(vehiculoDisponible, Integer.parseInt(lineaDividida[1]),Integer.parseInt(lineaDividida[2]), extrasDisponibles);
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

    private static ArrayList<Extra> recuperarExtrasDelVehiculo(String[] lineaDividida) {
        //tengo una lista de nombres de extras, necesito una funcion de getExtras con todos los posibles para ponerselo
    }

    private static Vehiculo recuperarVehiculoDisponible(String[] lineaDividida) {
        ArrayList<Vehiculo> vehiculos = getVehiculos();
        return vehiculos.stream().filter(vehiculo -> vehiculo.getIdItemAlmacen() == Integer.parseInt(lineaDividida[0])).findFirst().orElse(null);

    }

    public static ArrayList<Pedido> recuperarPedidos() throws IOException {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        BufferedReader lector = null;
        try {

            lector = new BufferedReader(new FileReader("Pedidos.csv"));
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                System.out.println(Arrays.toString(lineaDividida));
                Cliente cliente = recuperarClienteDePedido(lineaDividida);
                Modelo modelo = recuperarModeloDePedido(lineaDividida);
                Pedido pedido = new Pedido(cliente,modelo,Integer.parseInt(lineaDividida[2]));
                //no guardamos los extras para calcular el precio, pero los necesitamos para el constructor
                //2 soluciones, 1º los guardamos en el pedido, 2º, no son necesarios para el constructor, el precio se actualiza con una funcion si se añaden extras a ese objeto
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
}
