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
        Telefono tel1 = new Telefono("123456789", "Movistar");
        Telefono tel2 = new Telefono("987654321", "Telcel");
        Telefono tel3 = new Telefono("555666777", "AT&T");
        contacto1.agregarTel(tel1);
        contacto1.agregarTel(tel2);
        contacto1.agregarTel(tel3);

        Contacto contacto2 = new Contacto(2, "Maria", "Lopez", "maria@example.com", "./src/main/java/Imagenes/hollowknight.jpg");
        Telefono tel21 = new Telefono("222333444", "Unefon");
        Telefono tel22 = new Telefono("111222333", "Virgin Mobile");
        Telefono tel23 = new Telefono("333444555", "Telcel");
        contacto2.agregarTel(tel21);
        contacto2.agregarTel(tel22);
        contacto2.agregarTel(tel23);

        Contacto contacto3 = new Contacto(3, "Carlos", "Sanchez", "carlos@example.com", "./src/main/java/Imagenes/zorro.jpg");
        Telefono tel31 = new Telefono("444555666", "AT&T");
        Telefono tel32 = new Telefono("666777888", "Bait");
        Telefono tel33 = new Telefono("888999000", "Movistar");
        contacto3.agregarTel(tel31);
        contacto3.agregarTel(tel32);
        contacto3.agregarTel(tel33);

        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);
    }

    // Métodos para agregar, buscar, eliminar y modificar contactos
    public void agregarContacto(int id, String nombre, String apellido, String correo, String foto, String tel1, String tel2, String tel3, String com1, String com2, String com3) {
        
        Contacto nuevoContacto = new Contacto(id, nombre, apellido, correo, foto);
        
        if(!tel1.isEmpty()){
            Telefono nuevoTel1 = new Telefono(tel1, com1);
            nuevoContacto.agregarTel(nuevoTel1);
        }
        if(!tel2.isEmpty()){
            Telefono nuevoTel2 = new Telefono(tel2, com2);
            nuevoContacto.agregarTel(nuevoTel2);
        }
        if(!tel3.isEmpty()){
            Telefono nuevoTel3 = new Telefono(tel3, com3);
            nuevoContacto.agregarTel(nuevoTel3);
        }
        
        contactos.add(nuevoContacto);
    }
    
    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }
    
    public void modificarContacto(int id, String nombre, String apellido, String email, String foto, String tel1, String tel2, String tel3, String com1, String com2, String com3) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                contacto.setNombre(nombre);
                contacto.setApellido(apellido);
                contacto.setEmail(email);
                contacto.setFoto(foto);
                List<Telefono> ts = new ArrayList<>();
                if(!tel1.isEmpty()){
                    Telefono t1 = new Telefono(tel1, com1);
                    ts.add(t1);
                }
                if(!tel2.isEmpty()){
                    Telefono t2 = new Telefono(tel2, com2);
                    ts.add(t2);
                }
                if(!tel3.isEmpty()){
                    Telefono t3 = new Telefono(tel3, com3);
                    ts.add(t3);
                }
                
                contacto.setListaTel(ts);
                
                break;
            }
        }
    }
    
    public int siguienteId() {
        return IdActual++;
    }
    
    // Validaciones y búsquedas

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
