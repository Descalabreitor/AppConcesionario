/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class Concesionario {
   private static ArrayList<Cliente> clientes;
   private static ArrayList<Modelo> modelos;
   private static ArrayList<Vehiculo> vehiculos;
   
   

   public static Cliente crearCliente(String nombre, int telefono, String correo, String dni, String direccion,String contraseña){
       Cliente cliente = new Cliente(nombre,telefono,correo,dni,direccion,contraseña);
       clientes.add(cliente);
       //Meter al cliente en la persistencia
       return cliente;
   }
   
   public static Pedido crearPedido(Cliente cliente,Modelo modelo, ArrayList<Extra> extrasSeleccionados, int idPedido){
       Pedido pedido = new Pedido(cliente,modelo,extrasSeleccionados, idPedido);
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
   
   
    
    
}
