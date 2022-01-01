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
public class Cliente {
    
    private String nombre;
    private int telefono;
    private String correo;
    private String dni;
    private String direccion;
    private ArrayList<Pedido> pedidos;
    private String contraseña;

    public Cliente(String nombre, int telefono, String correo, String dni, String direccion, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.dni = dni;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }

    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    
}
