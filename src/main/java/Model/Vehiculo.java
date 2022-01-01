/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author adria
 */
public class Vehiculo {
    
    private boolean disponibilidad;
    private int idItemAlmacen;

    public Vehiculo(boolean disponibilidad, int idItemAlmacen) {
        this.disponibilidad = disponibilidad;
        this.idItemAlmacen = idItemAlmacen;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public int getIdItemAlmacen() {
        return idItemAlmacen;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
