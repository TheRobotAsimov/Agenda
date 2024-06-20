package Controlador;

import Modelo.Contacto;
import Modelo.Telefono;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactoControlador {
    private List<Contacto> contactos;
    private int IdActual;

    public ContactoControlador() {
        this.contactos = new ArrayList<>();
        this.IdActual = 1;
        inicializarDatos();
    }

    private void inicializarDatos() {
        // Inicializar con al menos tres contactos y cada uno con al menos tres teléfonos
        Contacto contacto1 = new Contacto(1, "Juan", "Perez", "juan@example.com", "./src/main/java/Imagenes/gatito.jpg");
        Telefono tel1 = new Telefono("1234567891", "Movistar");
        Telefono tel2 = new Telefono("9876543211", "Telcel");
        Telefono tel3 = new Telefono("5556667771", "AT&T");
        contacto1.agregarTel(tel1);
        contacto1.agregarTel(tel2);
        contacto1.agregarTel(tel3);

        Contacto contacto2 = new Contacto(2, "Maria", "Lopez", "maria@example.com", "./src/main/java/Imagenes/hollowknight.jpg");
        Telefono tel21 = new Telefono("2223334441", "Unefon");
        Telefono tel22 = new Telefono("1112223331", "Virgin Mobile");
        Telefono tel23 = new Telefono("3334445551", "Telcel");
        contacto2.agregarTel(tel21);
        contacto2.agregarTel(tel22);
        contacto2.agregarTel(tel23);

        Contacto contacto3 = new Contacto(3, "Carlos", "Sanchez", "carlos@example.com", "./src/main/java/Imagenes/zorro.jpg");
        Telefono tel31 = new Telefono("4445556661", "AT&T");
        Telefono tel32 = new Telefono("6667778881", "Bait");
        Telefono tel33 = new Telefono("8889990001", "Movistar");
        contacto3.agregarTel(tel31);
        contacto3.agregarTel(tel32);
        contacto3.agregarTel(tel33);

        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);
    }

    // Métodos para agregar, buscar, eliminar y modificar contactos
    public void agregarContacto(int id, String nombre, String apellido, String correo, String foto, String tel1, String tel2, String tel3, String com1, String com2, String com3) throws Exception {
        
        validarContacto(nombre, apellido, correo, tel1, tel2, tel3, com1, com2, com3);
        datoRepetido(correo, tel1, tel2, tel3, com1, com2, com3);

        
        if(foto.isEmpty()){
            foto = "./src/main/java/Imagenes/default.jpg";
        }
        
        Contacto nuevoContacto = new Contacto(id, nombre, apellido, correo, foto);
        
        TelefonoControlador telControlador = new TelefonoControlador();
        
        nuevoContacto.setListaTel(telControlador.crearListaTelefonos(tel1, tel2, tel3, com1, com2, com3));
        
        contactos.add(nuevoContacto);
    }
    
    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }
    
    public void modificarContacto(int id, String nombre, String apellido, String email, String foto, String tel1, String tel2, String tel3, String com1, String com2, String com3) throws Exception {
        
        validarContacto(nombre, apellido, email, tel1, tel2, tel3, com1, com2, com3);
        
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                datoRepetidoMod(contacto, email, tel1, tel2, tel3, com1, com2, com3);
                contacto.setNombre(nombre);
                contacto.setApellido(apellido);
                contacto.setEmail(email);
                if(foto.isEmpty()){
                    foto = "./src/main/java/Imagenes/default.jpg";
                }
                contacto.setFoto(foto);
                
                TelefonoControlador telControlador = new TelefonoControlador();

                contacto.setListaTel(telControlador.crearListaTelefonos(tel1, tel2, tel3, com1, com2, com3));
                
                break;
            }
        }
    }
    
    public int siguienteId() {
        return IdActual++;
    }
    
    // Validaciones y búsquedas
    
    public void validarContacto(String nombre, String apellido, String correo, String tel1, String tel2, String tel3, String com1, String com2, String com3) throws Exception{
        
        if(nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty()){
            throw new Exception("Faltan campos por llenar");
        }
        
        if(validarNombre(nombre) == 1){
            throw new Exception("No se permiten caracteres especiales en el nombre");
        }
        if(validarNombre(apellido) == 1){
            throw new Exception("No se permiten caracteres especiales en el apellido");
        }
        if(validarCorreo(correo) == 1){
            throw new Exception("Formato invalido para el correo");
        }
        
        
        TelefonoControlador telControlador = new TelefonoControlador();
        
        telControlador.validarTelefonos(tel1, tel2, tel3, com1, com2, com3);
    }
    
    public void datoRepetido(String correo, String tel1, String tel2, String tel3, String com1, String com2, String com3) throws Exception{
        if(buscarContactoPorCorreo(correo) != null){
            throw new Exception("Ese correo ya se encuentra registrado");
        }
        
        if(!tel1.isEmpty() && buscarContactoPorTelefono(tel1) != null){
            throw new Exception("El telefono "+tel1+" ya se encuentra registrado");
        }
        if(!tel2.isEmpty() && buscarContactoPorTelefono(tel2) != null){
            throw new Exception("El telefono "+tel2+" ya se encuentra registrado");
        }
        if(!tel3.isEmpty() && buscarContactoPorTelefono(tel3) != null){
            throw new Exception("El telefono "+tel3+" ya se encuentra registrado");
        }
    }
    
    public void datoRepetidoMod(Contacto contactoAntiguo, String correo, String tel1, String tel2, String tel3, String com1, String com2, String com3) throws Exception{
        if(buscarContactoPorCorreo(correo) != null && !correo.equals(contactoAntiguo.getEmail())){
            throw new Exception("Ese correo ya se encuentra registrado");
        }
        
        try{
            if(!tel1.isEmpty() && buscarContactoPorTelefono(tel1) != null && !tel1.equals(contactoAntiguo.getListaTel().get(0).getNumero())){
                throw new Exception("El telefono "+tel1+" ya se encuentra registrado");
            }
            if(!tel2.isEmpty() && buscarContactoPorTelefono(tel2) != null && !tel2.equals(contactoAntiguo.getListaTel().get(1).getNumero())){
                throw new Exception("El telefono "+tel2+" ya se encuentra registrado");
            }
            if(!tel3.isEmpty() && buscarContactoPorTelefono(tel3) != null && !tel3.equals(contactoAntiguo.getListaTel().get(2).getNumero())){
                throw new Exception("El telefono "+tel3+" ya se encuentra registrado");
            }
        } catch (Exception e){}
    }
    
    
    public int validarNombre(String nombre){
        if(!nombre.matches("^[a-zA-Z]+$")){
            return 1;
        }
        return 0;
    }

    public int validarCorreo(String correo){
        if(!correo.contains("@") || !correo.contains(".")){
            return 1;
        }
        
        return 0;
    }
    
    
    
    public List<Contacto> buscarContactoPorNombre(String nombre) {
        return contactos.stream()
                .filter(contacto -> contacto.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }
    
    public List<Contacto> buscarContactoPorApellido(String apellido) {
        return contactos.stream()
                .filter(contacto -> contacto.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
    }
    
    public Contacto buscarContactoPorCorreo(String correo) {
        for (Contacto contacto : contactos) {
            if (contacto.getEmail().equals(correo)) {
                return contacto;
            }
        }
        return null;
    }
    
    public Contacto buscarContactoPorTelefono(String telefono) {
        for (Contacto contacto : contactos) {
            for (Telefono t : contacto.getListaTel()){
                if (t.getNumero().equals(telefono)) {
                    return contacto;
                }
            }
        }
        return null;
    }
    
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public int getIdActual() {
        return IdActual;
    }

    public void setIdActual(int IdActual) {
        this.IdActual = IdActual;
    }
}
