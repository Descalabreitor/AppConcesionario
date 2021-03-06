package File;

import Model.Cliente;
import Model.Modelo;
import Model.Pedido;
import Model.Vehiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GuardarDatos {

    public void guardarClientes(ArrayList<Cliente> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Clientes");

        try {
            PrintWriter escritor= new PrintWriter(archivo);
            for (int i = 0; i < filas.size(); i++) {
                escritor.append(filas.get(i).getNombre() + ";" + filas.get(i).getTelefono() + ";" +
                        filas.get(i).getCorreo() + ";" + filas.get(i).getDni() + ";" +
                        filas.get(i).getDireccion() + ";" + filas.get(i).getContraseña() + "\n");
            }

            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarModelos(ArrayList<Modelo> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Modelos");
        ArrayList<String> extras = new ArrayList<String>();
        ArrayList<String> listaComentarios = new ArrayList<String>();
        try {
            PrintWriter escritor= new PrintWriter(archivo);
            for (int i = 0; i < filas.size(); i++) {
                for (int e = 0; e<filas.get(i).getExtrasDisponibles().size();e++){
                    extras.add(filas.get(i).getExtrasDisponibles().get(e).getNombre());
                }
                for (int j = 0; j <listaComentarios.size() ; j++) {
                    listaComentarios.add(filas.get(i).getComentarios().get(j).getAutorDni()+filas.get(i).getComentarios().get(j).getComentario());
                }
                escritor.append(filas.get(i).getNombre()  + ";" +
                        filas.get(i).getVehiculosDisponibles().toString()  + ";" +
                        filas.get(i).getIdModelo() + ";" +
                        filas.get(i).getPrecioBase() + ";" +
                        extras.toString() + ";" +
                        listaComentarios.toString() + "\n");
                extras.clear();
                listaComentarios.clear();
            }

            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarPedidos(ArrayList<Pedido> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Pedidos");
        ArrayList<String> extras = new ArrayList<String>();
        try {
            PrintWriter escritor= new PrintWriter(archivo);
            for (int i = 0; i < filas.size(); i++) {

                for (int e = 0; e<filas.get(i).getExtrasSeleccionados().size();e++){
                    extras.add(filas.get(i).getExtrasSeleccionados().get(e).getNombre());
                }

                escritor.append( filas.get(i).getCliente().getDni()+ ";" +
                        filas.get(i).getModelo().getIdModelo() + ";" +
                        extras.toString() + ";" +
                        filas.get(i).getPrecio() + ";" +
                        filas.get(i).getEstado() + ";" +
                        filas.get(i).getFechaEntrega() +"\n");
                extras.clear();
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
                escritor.append(filas.get(i).isDisponibilidad() + ";" +
                        filas.get(i).getIdItemAlmacen() +"\n");
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
            escritor.append("Nombre" + ";" + "Telefono" + ";" +
                    "Correo" + ";" + "Dni" + ";" +
                    "Direccion" + ";" + "Contraseña" + "\n");
        }
        else if ("Modelos".equals(nombreArchivo)){
            escritor.append("Nombre" + ";" + "Vehiculos disponibles" + ";" + "Id del Modelo" + ";" + "Precio Base" + ";" +
                    "Extras disponibles" + ":" + "Comentarios (dni+comentario)" + "\n");
        }
        else if ("Vehiculos".equals(nombreArchivo)){
            escritor.append("Disponibilidad" + ";" + "Id del almacen" +"\n");
        }

        else if ("Pedidos".equals(nombreArchivo)){
            escritor.append("Dni del cliente" + ";" + "Id del modelo"+";" + "Extras"+ ";" + "Precio" + ";" + "Estado del pedido" + ";" +
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