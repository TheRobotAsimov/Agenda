package Main;

import Controlador.ContactoControlador;
import Vista.Pantalla;


public class Main {
    public static void main(String[] args) {
        ContactoControlador controlador = new ContactoControlador();
        
        Pantalla p = new Pantalla(controlador);
        p.setVisible(true);
    }
}
