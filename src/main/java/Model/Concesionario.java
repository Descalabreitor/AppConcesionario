/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static File.recuperarDatos.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class Concesionario {
   private static ArrayList<Cliente> clientes;
   private static ArrayList<Modelo> modelos;
   private static ArrayList<Vehiculo> vehiculos;
   private static ArrayList<Pedido> pedidos;
   private static ArrayList<Extra> extras;
   private static Cliente clienteActual;
   
   

   public static Cliente crearCliente(String nombre, int telefono, String correo, String dni, String direccion, String contraseña){
       Cliente cliente = new Cliente(nombre,telefono,correo,dni,direccion,contraseña);
       clientes.add(cliente);
       //Meter al cliente en la persistencia
       return cliente;
   }
   
   public static Pedido crearPedido(Cliente cliente,Modelo modelo, ArrayList<Extra> extrasSeleccionados){
       Pedido pedido = new Pedido(cliente,modelo,extrasSeleccionados);
       cliente.addPedido(pedido);
       return pedido;
   }
   
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public static ArrayList<Extra> getExtras() {
        return extras;
    }

    
    public static void setClientes(ArrayList<Cliente> clientes) {
        Concesionario.clientes = clientes;
    }

    public static void setModelos(ArrayList<Modelo> modelos) {
        Concesionario.modelos = modelos;
    }

    public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        Concesionario.vehiculos = vehiculos;
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void setClienteActual(Cliente clienteActual) {
        Concesionario.clienteActual = clienteActual;
    }

    public void cargarDatos() throws IOException {
        pedidos=recuperarPedidos(); 
        clientes=recuperarClientes();
        modelos=recuperarModelos();
        vehiculos=recuperarVehiculos();
        pedidos=recuperarPedidos();
        extras=recuperarExtras();
    }
   
    
    
   
    
    
}
