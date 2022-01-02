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
public class Pedido {
    
    private String fechaEntrega;
    private Cliente cliente;
    private Modelo modelo;
    private ArrayList<Extra> extrasSeleccionados;
    private int precio;
    private Estado estado;

   

    public enum Estado {
        enCamino, etregado, peticionEnvidada
    }


    public Pedido(Cliente cliente, Modelo modelo, ArrayList<Extra> Extras) {
        this.cliente = cliente;
        this.modelo = modelo;
        this.estado = Estado.peticionEnvidada;
        this.extrasSeleccionados = Extras;
        calcularPrecio();
       
    }

    public void calcularPrecio(){
        Extra extraSeleccionado;
        int index = 0;
        int precioAñadido = 0;
        try{
            while(true){
                precioAñadido += this.extrasSeleccionados.get(index).getPrecioAñadido();
                index++;
            }
        }catch(Exception e){
        this.precio = modelo.getPrecioBase()+ precioAñadido;
        }
    }
    
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    


    
}
