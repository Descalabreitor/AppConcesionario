/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import Model.Cliente;
import Model.Modelo;
import Model.Pedido;
import Model.Vehiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class GuardarDatos {
    
    public void guardarClientes(ArrayList<Cliente> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Clientes");
        ArrayList<Integer> pedidos = new ArrayList<Integer>();
        try {
            PrintWriter escritor= new PrintWriter(archivo);
            for (int i = 0; i < filas.size(); i++) {
                for (int e = 0; e<filas.get(i).getPedidos().size();e++){
                    pedidos.add(filas.get(i).getPedidos().get(e).getIdPedido());
                }
                escritor.append(filas.get(i).getNombre() + ";" + filas.get(i).getDni() + ";" +
                        pedidos.toString() + ";" + filas.get(i).getContraseña() + ";" +
                        filas.get(i).getTelefono() + ";" + filas.get(i).getDireccion() + ";" +
                        filas.get(i).getCorreo() + "\n");
            }
            pedidos.clear();
            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarModelos(ArrayList<Modelo> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Modelos");
        ArrayList<String> extras = new ArrayList<>();
        try {
            PrintWriter escritor= new PrintWriter(archivo);
            for (int i = 0; i < filas.size(); i++) {
                for (int e = 0; e<filas.get(i).getExtrasDisponibles().size();e++){
                    extras.add(filas.get(i).getExtrasDisponibles().get(e).getNombre());
                }
                escritor.append(filas.get(i).getIdModelo() + ";" + filas.get(i).getPrecioBase() + ";" +
                        extras +"\n");
            }
            extras.clear();
            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarPedidos(ArrayList<Pedido> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Pedidos");
        try {
            PrintWriter escritor= new PrintWriter(archivo);
            for (int i = 0; i < filas.size(); i++) {
                escritor.append(filas.get(i).getModelo().getIdModelo() + ";" + filas.get(i).getCliente().getDni() + ";" +
                        filas.get(i).getPrecio() + ";" + filas.get(i).getEstado() + ";" +
                        filas.get(i).getFechaEntrega() +"\n");
            }
            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarVehiculos(ArrayList<Vehiculo> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Vehiculos");
        try {
            PrintWriter escritor= new PrintWriter(archivo);
            for (int i = 0; i < filas.size(); i++) {
                escritor.append(filas.get(i).getIdItemAlmacen() + ";" + filas.get(i).isDisponibilidad() +"\n");
            }
            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileWriter crearAbrirArchivo(String nombreArchivo) throws IOException {

        File a = new File(".\\predictive_model\\" + nombreArchivo + ".csv");
        if (a.exists()) {
            return new FileWriter(".\\predictive_model\\" + nombreArchivo + ".csv", true);
        } else {
            FileWriter escritorDeArchivo = new FileWriter(".\\predictive_model\\" + nombreArchivo + ".csv");

            PrintWriter escritor = new PrintWriter(escritorDeArchivo);
            escribirEncabezado(nombreArchivo, escritor);
            return escritorDeArchivo;
        }
    }

    private void escribirEncabezado(String nombreArchivo, PrintWriter escritor) {
        if ("Clientes".equals(nombreArchivo)){
            escritor.append("Nombre" + ";" + "Dni" + ";" +
                    "Pedidos" + ";" + "Contraseña" + ";" +
                    "Telefono" + ";" + "Direccion" + ";" +
                    "Correo" + "\n");
        }
        else if ("Modelos".equals(nombreArchivo)){
            escritor.append("Id del Modelo" + ";" + "Precio Base" + ";" +
                    "Extras disponibles" +"\n");
        }
        else if ("Vehiculos".equals(nombreArchivo)){
            escritor.append("Id del almacen" + ";" + "Disponibilidad" +"\n");
        }
        else if ("Pedidos".equals(nombreArchivo)){
            escritor.append("Id del modelo" + ";" + "Dni del cliente" + ";" +
                    "Precio" + ";" + "Estado del pedido" + ";" +
                    "Fecha de la entrega" +"\n");
        }
    }

    public void cerrarArchivo(FileWriter file) {
        try {
            if (null != file)
                file.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    
}
