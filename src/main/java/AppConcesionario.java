/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adria
 */

import Model.Concesionario;
import Model.Modelo;

import Gui.AppConcesionarioUI;
import java.util.ArrayList;

public class AppConcesionario {
    
    public static void main(String[] args){
        Concesionario concesionario = new Concesionario();
        ArrayList <Modelo>  testModelos = buildTestModelos();
    
    }

    private static ArrayList <Modelo> buildTestModelos() {
        ArrayList modelos = new ArrayList();
        for(int i = 0; i < 5;i++){
            Modelo modelo = new Modelo();
        }
        
        return null;
        
    }
    
    
    
    
}