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
public class Modelo {
    
    private String nombre;
    private Vehiculo vehiculoDisponibles;
    private int idModelo;
    private ArrayList<Extra> extrasDisponibles;
    private int precioBase;
    private ArrayList<Comentario> comentarios;


    public Modelo(String nombre,Vehiculo vehiculoDisponibles, int idModelo, int precioBase, ArrayList<Extra> extrasDisponibles) {
        
        this.nombre = nombre;
        this.vehiculoDisponibles = vehiculoDisponibles;
        this.idModelo = idModelo;
        this.extrasDisponibles = extrasDisponibles;
        this.precioBase = precioBase;
    }

    public void setExtrasDisponibles(ArrayList<Extra> extrasDisponibles) {
        this.extrasDisponibles = extrasDisponibles;
    }

    
    
    public Vehiculo getVehículoDisponibles() {
        return vehiculoDisponibles;
    }

    public int getIdModelo() {
        return idModelo;
    }


    public ArrayList<Extra> getExtrasDisponibles() {
        return extrasDisponibles;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public String getNombre() {
        return nombre;
    }

  

    public void addComentario(String texto, String autorDni){
        Comentario comentario = new Comentario(texto, autorDni);
        comentarios.add(comentario);
    }
    
}
