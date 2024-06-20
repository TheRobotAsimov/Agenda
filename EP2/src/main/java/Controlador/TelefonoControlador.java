package Controlador;

import Modelo.Telefono;
import java.util.ArrayList;
import java.util.List;

public class TelefonoControlador {

    public TelefonoControlador() {
    }
    
    public void validarTelefonos(String tel1, String tel2, String tel3, String com1, String com2, String com3) throws Exception{
        
        if(tel1.isEmpty() && tel2.isEmpty() && tel3.isEmpty()){
            throw new Exception("Debe haber por lo menos un telefono");
        }
        
        if(!tel1.isEmpty() && com1.isEmpty() || !tel2.isEmpty() && com2.isEmpty() || !tel3.isEmpty() && com3.isEmpty()){
            throw new Exception("A cada numero debe asignarse una compañia");
        }
        
        if(!tel1.isEmpty() && validarTelefono(tel1) == 1 || !tel2.isEmpty() && validarTelefono(tel2) == 1 || !tel3.isEmpty() && validarTelefono(tel3) == 1){
            throw new Exception("El telefono debe tener 10 numeros");
        }
        if(!tel1.isEmpty() && validarTelefono(tel1) == 2 || !tel2.isEmpty() && validarTelefono(tel2) == 2 || !tel3.isEmpty() && validarTelefono(tel3) == 2){
            throw new Exception("El numero telefonico solo debe tener numeros");
        }
        if(!tel1.isEmpty() && tel1.equals(tel2) || !tel1.isEmpty() && tel1.equals(tel3) || !tel2.isEmpty() && tel2.equals(tel3)){
            throw new Exception("Los numeros ingresados se repiten");
        }
    }
    
    public int validarTelefono(String telefono){
        if(telefono.length() != 10){
            return 1;
        }
        if(!telefono.matches("^[0-9]+$")){
            return 2;
        }
        
        return 0;
    }
    
    public List<Telefono> crearListaTelefonos (String tel1, String tel2, String tel3, String com1, String com2, String com3){
            List<Telefono> listaTelefonos = new ArrayList<>();

            if(!tel1.isEmpty()){
                Telefono nuevoTel1 = new Telefono(tel1, com1);
                listaTelefonos.add(nuevoTel1);
            }
            if(!tel2.isEmpty()){
                Telefono nuevoTel2 = new Telefono(tel2, com2);
                listaTelefonos.add(nuevoTel2);
            }
            if(!tel3.isEmpty()){
                Telefono nuevoTel3 = new Telefono(tel3, com3);
                listaTelefonos.add(nuevoTel3);
        }
            
        return listaTelefonos;
    }
}
