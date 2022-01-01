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
    
    private int idPedido;
    private String fechaEntrega;
    private Cliente cliente;
    private Modelo modelo;
    private int precio;
    private Estado estado;

    public int getIdPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum Estado {
        enCamino, etregado, peticionEnvidada
    }


    public Pedido(Cliente cliente, Modelo modelo, ArrayList<Extra> Extras, int idPedido) {
        this.cliente = cliente;
        this.modelo = modelo;
        this.estado = Estado.peticionEnvidada;
        calcularPrecio(Extras);
        this.idPedido = idPedido;
        
    }

    public void calcularPrecio(ArrayList<Extra> Extras){
        Extra extraSeleccionado;
        int index = 0;
        int precioAñadido = 0;
        try{
            while(true){
                precioAñadido += Extras.get(index).getPrecioAñadido();
                index++;
            }
        }catch(Exception e){
        this.precio = modelo.getPrecioBase()+ precioAñadido;
        }
    }
    
    public int getidPedido(){
        return idPedido;
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
