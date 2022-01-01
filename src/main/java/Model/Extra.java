/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author adria
 */
public class Extra {
    
    private String nombre;
    private String descripcion;
    private int precioAñadido;

    public Extra(String nombre, String descripcion, int precioAñadido) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioAñadido = precioAñadido;
    }

    public void setPrecioAñadido(int precioAñadido) {
        this.precioAñadido = precioAñadido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecioAñadido() {
        return precioAñadido;
    }
}

